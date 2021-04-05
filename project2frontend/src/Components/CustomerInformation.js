import React, {useState,useEffect} from 'react';
import { useSelector } from 'react-redux';
import CustomerOrders from './CustomerOrders';
// import 'bootstrap/dist/css/bootstrap.min.css'
import { Link } from 'react-router-dom';
import './CustomerInformation.css'

function CustomerInformation(props){
    let [user, setUser] = useState({username:'',password:'',firstName:'',lastName:'',email:'',userType:1,streetName:'',city:'',state:'',zipcode:'',userId:''});
    const currentUser = useSelector(state => state.user.Loggeduser)
    useEffect(() => {
        setUser({username:currentUser.username,password:currentUser.password,firstName:currentUser.firstName,lastName:currentUser.lastName,email:currentUser.email,streetName:currentUser.streetName,city:currentUser.city,state:currentUser.state,zipcode:currentUser.zipcode,userId:currentUser.userId})
    },[])
    return(
        <div >
            <div className="userInfo">
             <h2>Your Information</h2>
            <label for="UserName" >Username </label>
            <input name="UserName" value= {user.username} id="FirstName" readOnly/><br/>
            
            <label for="Email" >Email </label>
            <input name="Email" value= {user.email} id="FirstName" readOnly/><br/>
            
            <label for="FirstName" >FirstName </label>
            <input name="FirstName" value= {user.firstName} id="FirstName" readOnly/><br/>
            
            <label for="LastName" >LastName </label>
            <input name="LastName" value= {user.lastName} id="LastName" readOnly/><br/>
            
            <h2>Address Information</h2>
            <label for="StreeName">Street Name </label>
            <input for="StreetName" value= {user.streetName} type="text" readOnly/><br/>

            <label for="City">City </label>
            <input for="City" value= {user.city} type="text" readOnly/><br/>
            
            <label for="State">State </label>
            <input for="State" value= {user.state} type="text" readOnly/><br/>
             
            <label for="Zipcode">Zipcode </label>
            <input for="Zipcode" value= {user.zipcode} type="text" readOnly/><br/>
            
            <Link to="/ChangeInformation">
            <button>Click here to update your information</button>
            </Link>
            </div>

            <div className="orderInfo">
                <CustomerOrders />
            </div>
        </div>

    )
}

export default CustomerInformation