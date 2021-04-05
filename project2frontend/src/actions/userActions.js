import {LOGIN, LOGOUT,REGISTER,NEW_CUSTOMER_INFORMATION} from './types'
import UserServices from '../services/UserServices' 

export const loginUser = (user) => dispatch => {
    UserServices.getUserLogin(user.emailId, user.password).then(res =>{
        dispatch({
            type:LOGIN,
            payload:res.data
        })
    })
}

export const logoutUser = () => dispatch =>{
    dispatch({
        type:LOGOUT,
        payload:{}
    })
}
export const registerUser = (user) => dispatch => {
    UserServices.createUser(user).then(res=>{
        dispatch({
            type:REGISTER,
            payload:res.data
        })
    })
}
export const changeUserInformation = (user) => dispatch => {
    UserServices.updateUserAddress(user,user.userId).then(res => {
        dispatch({
            type: NEW_CUSTOMER_INFORMATION,
            payload: res.data
          })
    })
}