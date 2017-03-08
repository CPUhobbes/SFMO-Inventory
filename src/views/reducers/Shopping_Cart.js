import {ADD_ITEM, REMOVE_ITEM} from '../constants';

//Initial State
const initialState = {
    cart:[]
}

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

//Cart
const cart = (state=initialState, action) => {

    let location = findItem(action.item, state.cart);

    switch (action.type){
        case ADD_ITEM:
        
            //Item does not exist, add item
            if(location<0){
                return { cart : [...state.cart, {item:action.item, quantity:action.quantity}]}
            }

            //Update quantity of item
            else{
                return {cart: state.cart.map((item, index) =>{
                    if(index!==location){
                       return item;
                    }
                    return{
                        item:item.item,
                        quantity:(item.quantity+action.quantity)

                    }
                })
            }}

        case REMOVE_ITEM:
            
            return { cart : [...state.cart.slice(0, location), ...state.cart.slice(location+1) ] }
            
        default:  
            return state
    }
}


export default cart;