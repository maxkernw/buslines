import { customElements } from '../../window';
import mock from 'mock-require';
import stopElementStyles from './stop-element-styles';


describe('Stop Element', () => {
    let StopElement;
    beforeEach(() => {
        spyOn(customElements, 'define');

        StopElement = mock.reRequire('./stop-element').StopElement;
    });

    it('register StopElement as custom element', () => {
        expect(customElements.define).toHaveBeenCalledWith(StopElement.tagName, StopElement);
    });

    it('should set expected attribute: name', () => {
        const expectedName = 'foo'
        const stopElement = new StopElement();
        spyOn(stopElement, 'getAttribute').and.returnValue(expectedName);
        stopElement.connectedCallback();
       
        expect(stopElement.name).toEqual(expectedName);
    });

    it('should set expected attribute: lat', () => {
        const expectedLat = "2.021323";
        const stopElement = new StopElement();
        spyOn(stopElement, 'getAttribute').and.returnValues('foo', expectedLat);
        stopElement.connectedCallback();
       
        expect(stopElement.lat).toEqual(expectedLat);
    });

    it('should set expected attribute: lng', () => {
        const expectedLng = "2.021323";
        const stopElement = new StopElement();
        spyOn(stopElement, 'getAttribute').and.returnValues('foo', 'bar', expectedLng);
        stopElement.connectedCallback();
       
        expect(stopElement.lng).toEqual(expectedLng);
    });
});