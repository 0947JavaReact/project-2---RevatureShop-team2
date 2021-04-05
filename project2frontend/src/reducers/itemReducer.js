import {NEW_ITEM,FETCH_ITEMS} from '../actions/types'


const initialState = {
    items:[]
}

export default function(state = initialState, action) {
    switch (action.type) {
        case NEW_ITEM:
            return {
                ...state
            };
        case FETCH_ITEMS:
            return {
            ...state,
            items: action.payload 
            }
      default:
        return state;
    }
  }