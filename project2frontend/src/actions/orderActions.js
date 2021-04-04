import {NEW_ORDER,FETCH_ORDERS} from './types'
import OrderServices from '../services/OrderServices'
import UserServices from '../services/UserServices'


export const newOrder = (orderData) =>dispatch => {
    OrderServices.createOrder(orderData)
   
    dispatch({
        type: NEW_ORDER,
        payload:  UserServices.getUserById(orderData.creator)
      })
}

export const fetchOrders = (userID) => dispatch => {
    OrderServices.getOrderByUserId(userID).then(res => {
        dispatch({
            type: FETCH_ORDERS,
            payload: res.data
          })
    })
}