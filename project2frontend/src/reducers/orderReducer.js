import {NEW_ORDER,FETCH_ORDERS} from '../actions/types'

const initialState = {
    orders:[]
}

export default function(state = initialState, action) {
    switch (action.type) {
        case NEW_ORDER:
            return {
                ...state,
                Loggeduser:action.payload
            };
        case FETCH_ORDERS:
                return {
                    ...state, 
                    orders: action.payload 
                }
      default:
        return state;
    }
  }
     