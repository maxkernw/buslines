
import { fromEvent, Subscription } from "rxjs";
import styles from './stops-element-styles';
import { customElements } from '../../window';
import BaseElement from '../base-element';

const template = document.createElement('template');
template.innerHTML = `
    ${styles}
    <div class="stops"></div>
`;
export class StopsElement extends BaseElement {

    static get tagName() {
        return 'stops-element';
    }

    constructor() {
        super(template);
        this.lineClickedSubscription = Subscription.EMPTY;
        
        this.stops = this.shadowRoot.querySelector('div');
        this.lineClicked = this.lineClicked.bind(this);
    }

    connectedCallback() {
        this.lineClickedSubscription = fromEvent(document, 'lineClicked').subscribe(this.lineClicked);
    }

    disconnectedCallback() {
        this.lineClickedSubscription.unsubscribe();

    }

    lineClicked(event) {
        const data = event.detail.stops.reduce((acc, e) => {
            if (acc.includes(e.name)) {
                return acc;
            }
            return acc.includes(e.name) ? acc : `${acc}<stop-element name="${e.name}" lat="${e.latitude}" lng="${e.longitude}"></stop-element>`;
        }, '');
        this.stops.innerHTML = data;
    }
}

customElements.define(StopsElement.tagName, StopsElement);