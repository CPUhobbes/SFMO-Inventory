import {ADD_ITEM, REMOVE_ITEM} from '../constants';

//Helper Functions
function findItem(item, arr){
    let location = -1;
    arr.forEach(function(value, index){
        if(item===value.item){
            location = index; 
        }
    });
    return location;
}

// function updateQuantity(item, arr){



// }



const initialState = {
    cart:[]
}


const cart = (state=initialState, action) => {
    switch (action.type){
        case ADD_ITEM:
            return { cart : [...state.cart, {item:action.item, quantity:action.quantity}]}
        case REMOVE_ITEM:
            let location = findItem(action.item, state.cart);

            //console.log(location);
            return { cart : [...state.cart.slice(0, location), ...state.cart.slice(location+1) ] }
        default:  
            return state
    }
}


export default cart;