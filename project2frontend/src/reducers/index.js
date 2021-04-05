import { combineReducers } from 'redux';
import cartReducer from './cartReducer'
import orderReducer from './orderReducer'
import userReducer from './userReducer'
import itemReducer from './itemReducer'

export default combineReducers({
    cart: cartReducer,
    order: orderReducer,
    user: userReducer,
    item: itemReducer
});