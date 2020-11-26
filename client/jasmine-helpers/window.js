const { JSDOM } = require('jsdom');

const document = (new JSDOM('<!DOCTYPE html>')).window.document;

const window = {
    HTMLElement: class HTMLElement {
        attachShadow() {
            console.log('called')
            this.shadowRoot = document.createElement('template');
        }
        getAttribute() {}
    },
    customElements: {
        define: () => { }
    },
    createElement: () => {},
    URL: {createObjectUrl: () => {}}
};

Object.freeze(window);
global.window = window;
global.document = document;
