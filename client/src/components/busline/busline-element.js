import { fromEvent, Subscription } from "rxjs";
import { AppState } from "../../app.state";
import BaseElement from "../base-element";
import styles from './busline-element-styles';
import buslineTemplate from './busline-element-template';
import { customElements } from '../../window';

const template = document.createElement('template');

template.innerHTML = `
  ${styles}
  ${buslineTemplate}
`;

export class BusLineElement extends BaseElement {
    
    static get tagName() {
        return 'line-element';
    }
    
    constructor() {
        super(template);
        this.clickSubscription = Subscription.EMPTY;
    }

    connectedCallback() {
        this.$lineNumber = this.shadowRoot.querySelector('.line');
        this.$stops = this.shadowRoot.querySelector('.stops');
        this.container = this.shadowRoot.querySelector('.container');

        const lineNumber = this.getAttribute('lineNumber');
        const busline = AppState.buslines.find(x => x.lineNumber === parseInt(lineNumber));

        this.clickSubscription = fromEvent(this.shadowRoot, 'click').subscribe(click => {
            document.dispatchEvent(new CustomEvent('lineClicked', { detail: busline }))
        })
        this.$lineNumber.textContent = `${AppState.buslines.indexOf(busline) + 1}. ${busline.lineNumber}`;

        setTimeout(() => this.container.style.opacity = 1, 500)
    }

    disconnectedCallback() {
        this.clickSubscription.unsubscribe();
    }

}

customElements.define(BusLineElement.tagName, BusLineElement);