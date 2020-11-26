import styles from '../../app.styles'
export default /*html */`
<style>
    .stop {
        display:grid;
        grid-template-columns: 1fr;
        grid-gap: 5px;
        background:${styles.colors.$light};
        white-space: nowrap;
        align-items: center;
        justify-items: center;
        overflow: hidden;
        text-overflow: ellipsis;
        border-radius: 2px;
        transition: .2s;
        box-shadow:${styles.shadows.$primary};
        padding: 0 1rem 0 1rem;
        cursor: pointer;
    }
    .stop:hover {
        color:white;
        background: ${styles.colors.$dark};
    }
</style>
`