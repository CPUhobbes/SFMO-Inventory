const initialState = {
    number:0
}


const cart = (state=initialState, action) => {
    switch (action.type){
        case 'INCREASE':
            return { number: (state.number+1)}
        default: 
            return { number: state.number}
    }
}

export default cart;