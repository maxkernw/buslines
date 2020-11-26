
import { fromEvent } from 'rxjs';
import MapService from '../../services/map.service';
import BaseElement from '../base-element';
import styles from './map-element-styles';
import mapTemplate from './map-element-template';
import { customElements } from '../../window';

const template = document.createElement('template');

template.innerHTML = `
    ${styles}
    ${mapTemplate}
`;

export class MapElement extends BaseElement {

    static get tagName() {
        return 'map-element';
    }

    constructor() {
        super(template);

        this.mapContainer = this.shadowRoot.querySelector('div');
        this.loading = this.shadowRoot.querySelector('.loading');
        this.lineClicked = this.lineClicked.bind(this);
        this.addMarkers = this.addMarkers.bind(this)
    }

    async connectedCallback() {
        this.mapService = new MapService(this.mapContainer, 0, 0);
        this.map = this.mapService.map;

        this.lineClickedSubscription = fromEvent(document, 'lineClicked').subscribe(this.lineClicked);
        this.resizeSubscription = fromEvent(window, 'resize').subscribe(() => this.map.resize());
        this.stopClickedSubscription = fromEvent(document, 'stopClicked').subscribe(e =>
            this.map.flyTo({ center: [e.detail.lng, e.detail.lat], zoom: 15 })
        );

        this.mapLoadedSubscription = fromEvent(this.map, 'load').subscribe(() => {
            this.map.resize();
            this.mapContainer.style.opacity = .2;
            this.loading.style.opacity = 0;
            console.log('loaded')
            document.dispatchEvent(new CustomEvent('mapLoaded', {}))
        })
    }

    disconnectedCallback() {
        this.lineClickedSubscription.unsubscribe();
        this.resizeSubscription.unsubscribe();
        this.stopClickedSubscription.unsubscribe();
        this.mapLoadedSubscription.unsubscribe();
    }

    lineClicked(event) {
        this.mapService.clearLayers();
        this.data = event.detail;

        this.addMarkers();
        const [stop] = this.data.stops;

        this.map.flyTo({ center: [stop.longitude, stop.latitude], zoom: 10 })
        this.map.resize()
    }

    addMarkers() {

        this.mapContainer.style.opacity = 1;

        this.mapService.addMakers(this.data.stops);
    }
}

customElements.define(MapElement.tagName, MapElement);