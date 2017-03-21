import Inventory from '../../../controllers/inventoryController';



const helpers = {
    findItemByID: (item, arr) => {
        let location = -1;
        arr.forEach(function(value, index){
            if(item===value.id){
                location = index; 
            }
        });
        return location;
    },

    findItemByName:(name) => {
        return Inventory.searchInventory(name);
       
    }
}

export default helpers;