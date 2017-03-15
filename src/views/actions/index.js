import {ADD_ITEM, REMOVE_ITEM, UPDATE_SEARCH} from '../constants';

export function addToCart(id, name, quantity){
    return {
        type: ADD_ITEM,
        id:id,
        name: name,
        quantity: quantity
    }
}

export function removeFromCart(id, name, quantity){
    return{
        type: REMOVE_ITEM,
        id: id,
        name: name,
        quantity: quantity
    }
}

export function updateSearch(value){
    return{
        type: UPDATE_SEARCH,
        value: value
    }
}

