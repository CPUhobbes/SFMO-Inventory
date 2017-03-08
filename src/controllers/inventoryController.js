import Inventory from './../models/inventoryModel';

let inventoryList ={};


//Load inventory
try{
    inventoryList = Inventory;
}
catch(err){
    console.log("Cannot read Database");
}

//Inventory Methods

const inventoryController = {
    
     getInventory: () => {
        return inventoryList;
    }

}

export default inventoryController;