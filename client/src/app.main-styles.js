import styles from './app.styles';

export default /*html*/`
<style>
    :host {
        display:block;
        background: ${styles.colors.$background};
    }
    .container {
        display:grid;
        grid-template-areas:
            "nav nav"
            "main map"
            "stops map";

        height: 100vh;
        grid-template-rows: 50px auto 1fr;
        grid-template-columns: auto 1fr;
        grid-gap: 1rem;
        overflow:hidden;
        padding:0 2rem 0 2rem;
    }
    .result {
        grid-area: main;
        width: 100%;
        min-height: 100%;
        max-height: 100%; 
    }
    nav {
        grid-area: nav;
        display:grid;
        align-items: center;
    }
    nav span {
        color:${styles.colors.$textColorLight};
        text-shadow: ${styles.shadows.$primary};
        font-weight: bolder;
        font-size: 25px;
    }
    .buslines-container {
        grid-area: main;
        display:grid;
    }
    .busLines {
        display:grid;
        grid-gap: 1rem;        
        grid-template-columns: repeat(auto-fit, minmax(80px, 1fr));
        opacity: 0;
        transition: opacity .2s;
    }

    .map-container {
        grid-area:map;
        width:100%;  
        height: 100vh; 
    }
    .stops-container {
        grid-area: stops;
        overflow: scroll;
        width:100%;
        height: 100%;

    }
    .loading {
        transition: .2s;
    }
    ::-webkit-scrollbar
    {
        display:none;
        background-color: transparent
    }

</style>
`