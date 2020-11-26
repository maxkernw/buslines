import { customElements } from '../../window';
import mock from 'mock-require';


describe('Buslines Element', () => {
    let Buslines;
    beforeEach(() => {
        spyOn(customElements, 'define');

        Buslines = mock.reRequire('./busline-element').BusLineElement;
    });

    it('register Buslines as custom element', () => {
        expect(customElements.define).toHaveBeenCalledWith(Buslines.tagName, Buslines);
    });
});