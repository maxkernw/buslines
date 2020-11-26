import { customElements } from '../../window';
import mock from 'mock-require';

describe('Loading Element', () => {
    let LoadingElemnent;
    beforeEach(() => {
        spyOn(customElements, 'define');

        LoadingElemnent = mock.reRequire('./loading-element').LoadingElement;
    });

    it('register LoadingElemnent as custom element', () => {
        expect(customElements.define).toHaveBeenCalledWith(LoadingElemnent.tagName, LoadingElemnent);
    });
});