const helpers = {
    findItemByID: (item, arr) => {
        let location = -1;
        arr.forEach(function(value, index){
            if(item===value.id){
                location = index; 
            }
        });
        return location;
    }
}

export default helpers;