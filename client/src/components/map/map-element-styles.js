export default /*html*/`
<style>
    .mapboxgl-control-container {
        display:none
    }
    :host {
        display:grid;
        height: 100%;
        width: 100%;
    }
    .container {
        position: relative;
        height: 100% !important;
        width: 100% !important;
    
    }
    .mapboxgl-canvas-container {
        position: absolute;
        top: 0;
        bottom: 0;
        width: 100%;

    }
    #map {
        width: 100%;
        height: 100%;
        opacity: 0;
        transition: .5s;
    }
    .loading {
        opacity:0;  
        transition: .2s;
    }
</style>
`