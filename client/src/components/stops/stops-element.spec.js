import { customElements } from '../../window.js';
import mock from 'mock-require';

describe('Stops Element', () => {
    let StopsElement;
    beforeEach(() => {
        spyOn(customElements, 'define');

        StopsElement = mock.reRequire('./stops-element').StopsElement;
    });

    it('register stopselement as custom element', () => {
        expect(customElements.define).toHaveBeenCalledWith(StopsElement.tagName, StopsElement);
    });

    it('should display stop element', () => {
        const expected = '<stop-element name="d" lat="0" lng="0"></stop-element>';
        const stopsElement = new StopsElement();
        
        stopsElement.lineClicked({ detail: { stops: [{ name: 'd', latitude: 0, longitude: 0 }] } });
        
        const stops = stopsElement.shadowRoot.querySelector('div').innerHTML;

        expect(stops).toEqual(expected);
    });

    it('should open subscription', () => {
        const stopsElement = new StopsElement();
        
        stopsElement.connectedCallback();
        

        expect(stopsElement.lineClickedSubscription.closed).toEqual(false);

    });

    it('should close subscription', () => {
        const stopsElement = new StopsElement();
        
        stopsElement.connectedCallback();
        

        stopsElement.disconnectedCallback();
        expect(stopsElement.lineClickedSubscription.closed).toEqual(true);

    });
});