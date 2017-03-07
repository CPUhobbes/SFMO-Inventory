const initialState = {
    cart:[]
}


const cart = (state=initialState, action) => {
    switch (action.type){
        case 'ADD':
            return { cart: (state.cart.push([action.item, action.quantity]))}
        default: 
            return { cart: state.cart }
    }
}

export default cart;