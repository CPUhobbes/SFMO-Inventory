import Inventory from './../models/inventoryModel';

const _ = require('lodash');

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
    },

    searchInventory: (term) => {
        let query ='';
        if(typeof term !== 'undefined'){
            query = term.toLowerCase();
        }
        if (query!==''){
            return  _.filter(
                        _.flatten(
                            _.map(inventoryList.inventory, (val)=>{
                                return val;
                        })), (items) =>{
                            return items.name.toLowerCase().indexOf(query) > -1;
                                
                    });
        }
        else{
            return []; 
        }
    }
}

export default inventoryController;