import BaseElement from '../base-element';
import style from './loading-element-styles';
import { customElements } from '../../window';

const template = document.createElement('template');
template.innerHTML = `
    ${style}
    <div class="lds-dual-ring"></div>
`;

export class LoadingElement extends BaseElement {

    static get tagName() {
        return 'loading-element';
    }

    constructor() {
        super(template);
    }
}

customElements.define(LoadingElement.tagName, LoadingElement);