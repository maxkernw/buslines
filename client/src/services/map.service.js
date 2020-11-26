

import mapboxgl, { Map } from 'mapbox-gl';
import environment from '../environment';

mapboxgl.accessToken = environment.MAPBOX_KEY;

const layer = {
    id: 'points',
    type: 'symbol',
    source: 'points',
    layout: {
        'icon-image': 'custom-marker',
        'icon-size': .08,
        'icon-padding': 0,
        'text-field': ['get', 'title'],
        'text-font': [
            'Open Sans Semibold',
            'Arial Unicode MS Bold'
        ],
        'text-offset': [0, 1.25],
        'text-anchor': 'top'
    }
}
export default class {
    constructor(mapContainer, lng, lat) {
        this.map = new Map({
            container: mapContainer,
            style: environment.MAPOX_STYLE_URL,
            center: [lng, lat],
            zoom: 1,
        });
    }
    
    mapStops(stops) {
        return stops.map(stop => ({
            type: 'Feature',
            geometry: {
                type: 'Point',
                coordinates: [
                    stop.longitude,
                    stop.latitude
                ]
            },
            properties: {
                title: stop.name
            }
        }));
    }

    clearLayers() {
        if (this.map.getLayer('points')) {
            this.map.removeLayer("points");
        }
        if (this.map.getSource('points')) {
            this.map.removeSource('points');
        }
    }

    addMakers(stops) {
        this.map.loadImage(
            'bus.png',
            (error, image) => {
                if (!this.map.hasImage('custom-marker')) {
                    this.map.addImage('custom-marker', image);
                }

                if(error) {
                    console.error(error);
                    return;
                }
                // Add a GeoJSON source with 2 points
                this.map.addSource('points', {
                    'type': 'geojson',
                    'data': {
                        'type': 'FeatureCollection',
                        'features': this.mapStops(stops)
                    }
                });

                this.map.addLayer(layer);
            });
    }

}
