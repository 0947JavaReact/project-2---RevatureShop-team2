import {LOGIN, LOGOUT,REGISTER,NEW_CUSTOMER_INFORMATION} from '../actions/types'

const initialState = {
    Loggeduser:{
    userId:0,
    username:"",
    password:"",
    firstName:"",
    lastName:"",
    email:"",
    streetName:"",
    city:"",
    zipcode:"",
    }
}

export default function(state = initialState, action) {
    switch (action.type) {
        case LOGIN:
            return {
                ...state, 
                Loggeduser: action.payload 
            };
        case LOGOUT:
            return initialState;
        case REGISTER:
            return {
                Loggeduser: action.payload 
            };
        case NEW_CUSTOMER_INFORMATION:
           return {
                ...state, 
                firstName: action.payload.firstName,
                lastName:action.payload.lastName,
                streetName:action.payload.streetName,
                city:action.payload.city,
                zipcode:action.payload.zipcode,
            };
      default:
        return state;
    }
  }
      