import {FETCH_CART,ADD_CART,CLEAR_CART} from './types'

export const addToCart = (user) => dispatch => {
    axios.post("http://localhost:9025/cart/add", {
        userId : user.id, 
        name : currItem.name, 
        price : currItem.price, 
        itemId : currItem.itemId
    }).then(res =>{
        dispatch({
            type:ADD_CART,
            payload:res.data
        })
    })
}