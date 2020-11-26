import styles from '../../app.styles';

export default `
<style>
    .container {
        opacity: 0;
        transition: 1s;
        box-shadow: ${styles.shadows.$primary};
        transition: .3s;
        border-radius: 5px;
        background-color: ${styles.colors.$light};
        height:100%;
        display:grid;
        align-items:center;
        justify-items:center;
        user-select:none;
        cursor: pointer;
    }
    
    .container:hover {
        background:${styles.colors.$dark};
        color: ${styles.colors.$textColorLight};
    }
    
    .info {
        display:grid;
        align-items: center;
        justify-items:center;
        font-weight: bolder;
    }
    .img-container {
        position: relative;
        text-align: center;
    }

    img {
        border-top: 1px solid ${styles.colors.$dark};
        width:100%;
    }
    .container:hover img {
        filter: grayscale(1) invert(100%);

    }
   
</style>`;