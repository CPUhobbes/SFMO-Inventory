import {ADD_ITEM, REMOVE_ITEM} from '../constants';

export function addToCart(item, quantity){
    
    return {
        type: ADD_ITEM,
        item: item,
        quantity: quantity
    }
}

export function removeFromCart(item, quantity){
    return{
        type: REMOVE_ITEM,
        item: item,
        quantity: quantity
    }
}

