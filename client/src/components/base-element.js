
import { HTMLElement } from '../window.js';

class BaseElement extends HTMLElement {
    constructor(template) {
        super();
        this.attachShadow({ mode: 'open' });
        this.shadowRoot.appendChild(template.content.cloneNode(true));
    }
}
export default BaseElement;