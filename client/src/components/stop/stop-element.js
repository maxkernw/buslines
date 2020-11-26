import { fromEvent, Subscription } from "rxjs";
import BaseElement from "../base-element";
import style from './stop-element-styles';
import { customElements } from '../../window';

const template = document.createElement('template');


template.innerHTML = `
    ${style}
    <div class="stop"><span></span></div>
`;

export class StopElement extends BaseElement {
    static get tagName() {
        return 'stop-element';
    }
    constructor() {
        super(template);
        this.clickSubscription = Subscription.EMPTY;
    }

    connectedCallback() {
        this.span = this.shadowRoot.querySelector('span');

        this.name = this.getAttribute('name');
        this.lat = this.getAttribute('lat') || 0;
        this.lng = this.getAttribute('lng') || 0;

        this.span.textContent = this.name;

        this.clickSubscription = fromEvent(this.shadowRoot, 'click').subscribe(_ =>
            document.dispatchEvent(new CustomEvent('stopClicked', { detail: { lat: parseFloat(this.lat), lng: parseFloat(this.lng) } }))
        )
    }

    disconnectedCallback() {
        this.clickSubscription.unsubscribe();
    }

}

customElements.define(StopElement.tagName, StopElement);