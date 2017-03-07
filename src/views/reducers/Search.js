import {UPDATE_SEARCH} from '../constants';

const initialState = {
    search:""
}


const search = (state=initialState, action) => {
    switch (action.type){
        case UPDATE_SEARCH:
            return { Search: action.value}

        default:  
            return state
    }
}


export default search;