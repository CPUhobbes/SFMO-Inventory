export function addToCart(item, quantity){
    
    return {
        type: 'ADD',
        item: item,
        quantity: quantity

    }

}