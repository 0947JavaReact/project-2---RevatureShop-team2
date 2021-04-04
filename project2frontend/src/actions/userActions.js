import {LOGIN, LOGOUT,REGISTER,NEW_CUSTOMER_INFORMATION} from './types'
import UserServices from '../services/UserServices' 

export const loginUser = () => {

}

export const logoutUser = () => {
    
}
export const registerUser = () => {
    
}
export const changeUserInformation = (user) => dispatch => {
    UserServices.updateUserAddress(user,user.userId).then(res => {
        dispatch({
            type: NEW_CUSTOMER_INFORMATION,
            payload: res.data
          })
    })
}