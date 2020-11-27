import styles from '../../app.styles';

export default /*html*/`
<style>
:host {
      position: absolute;
      top: 50%;
      left: 50%; 
      transform: translate(-50%, -50%);

}
.lds-dual-ring {
  display: inline-block;
  width: 80px;
  height: 80px;
}
.lds-dual-ring:after {
  content: " ";
  display: block;
  width: 64px;
  height: 64px;
  margin: 8px;
  border-radius: 50%;
  border: 6px solid ${styles.colors.$light};
  border-color: ${styles.colors.$light} transparent ${styles.colors.$light} transparent;
  animation: lds-dual-ring 1.2s linear infinite;
}
@keyframes lds-dual-ring {
  0% {
    transform: rotate(0deg);
  }
  100% {
    transform: rotate(360deg);
  }
}

</style>`