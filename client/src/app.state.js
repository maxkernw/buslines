

export const AppState = {
    buslines: [],
    clickedBusline: undefined,
    addBuslines: (buslines) => {
        AppState.buslines = buslines;
    }

};