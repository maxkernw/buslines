import './components/map/map-element';
import './components/stops/stops-element';
import './components/stop/stop-element';
import './components/loading/loading-element';
import './components/busline/busline-element'

import { get } from './services/http.service.js';
import { AppState } from './app.state'
import mainStyle from './app.main-styles';
import mainTemplate from './app.main-template';
import environtment from './environment';
import { fromEvent } from 'rxjs';

const template = document.createElement('template');

template.innerHTML = `
    ${mainStyle}
    ${mainTemplate}
`;

class App extends HTMLElement {
    constructor() {
        super();

        this._shadowRoot = this.attachShadow({ mode: 'open' });
        this._shadowRoot.appendChild(template.content.cloneNode(true));

        this.buslines = this._shadowRoot.querySelector('.busLines');
        this.loading = this._shadowRoot.querySelector('.loading');
        this.container = this._shadowRoot.querySelector('.container');
        this.mapContainer = this._shadowRoot.querySelector('.map-container');

    }

    async connectedCallback() {
        this.buslinesData = await get(environtment.ENDPOINT);
        
        if (!this.buslinesData) {
            this.loading.style.opacity = 0;
            return this.container.innerHTML = '<h1>Unable to load app!</h1>';
        }
        
        AppState.addBuslines(this.buslinesData);
        this.mapLoadedSubscription = fromEvent(document, 'mapLoaded').subscribe(() => {
            this.loading.style.opacity = 0;
            this.buslines.style.opacity = 1;
        });

        this.renderBuslines();

    }
    disconnectedCallback() {
        this.mapLoadedSubscription.unsubscribe();
    }
    renderBuslines() {
        const render = this.buslinesData.reduce((acc, busline) => `${acc}<line-element class="line" style="opacity:0; transition: .2s" lineNumber="${busline.lineNumber}"></line-element>`, '');

        this.buslines.innerHTML = render;
        this.buslines.querySelectorAll('.line').forEach(e => e.style.opacity = 1);
        this.mapContainer.innerHTML = "<map-element></map-element>";
    }
}

window.customElements.define('buslines-app', App);