import { connect } from "react-redux"
import React, {useState,useEffect } from 'react';
import {changeUserInformation} from '../actions/userActions'
import { useDispatch, useSelector } from 'react-redux';
import './ChangeInformation.css';
import USPS from 'usps-webtools'



//allow user to change firstname, lastname, street address, city, state, zipcode
//address will be validated, if not 
function ChangeInformation(props){
   let [user, setUser] = useState({username:'',password:'',firstName:'',lastName:'',email:'',userType:1,streetName:'',city:'',state:'',zipcode:'',userId:''});
    const currentUser = useSelector(state => state.user.Loggeduser)
    const dispatch = useDispatch();

    useEffect(() => {
            setUser({username:currentUser.username,password:currentUser.password,firstName:currentUser.firstName,lastName:currentUser.lastName,email:currentUser.email,streetName:currentUser.streetName,city:currentUser.city,state:currentUser.state,zipcode:currentUser.zipcode,userId:currentUser.userId})
            
        },[])
    const usps = new USPS({
        server: 'http://production.shippingapis.com/ShippingAPI.dll',
        userId: '344UNIVE0189',
        ttl: 10000 //TTL in milliseconds for request
      });

    function  onSubmit(){
        
        usps.verify({
            street1: user.streetName,
            street2: '',
            city: user.city,
            state: user.state,
            zip: user.zipcode
          }, function(err, address) {
              console.log(address)
            if(!address){
                    alert("**INVALID INFORMATION WAS INPUTTED**")
                    window.location.reload();
            }
            else{
                dispatch(changeUserInformation(user));
                alert("User information updated correctly")
            }
          });
          
    }
    const onChange = (e) => {
        setUser({ ...user,[e.target.name]: e.target.value}) 
    }
    return(
        <div>
                <h1>Update Information </h1>
                <h6>*You cannot change your Username or your email*</h6>
                <label for="UserName" >Username </label>
                <input name="UserName" value= {user.username} id="username" readOnly/><br/>
                
                <label for="Email" >Email </label>
                <input name="Email" value= {user.email} id="email" readOnly/><br/>
                
                <label for="FirstName" >FirstName </label>
                <input name="firstName" value= {user.firstName} onChange={onChange} id="firstName" /><br/>
                
                <label for="LastName" >LastName </label>
                <input name="lastName" value= {user.lastName} onChange={onChange} id="lastName" /><br/>
                
                <h2>Update Address Information</h2>
                <label for="StreeName">Street Name </label>
                <input name="streetName" value= {user.streetName} onChange={onChange} type="text" id="streetName"/><br/>

                <label for="City">City </label>
                <input name="city" value= {user.city} onChange={onChange}  type="text" /><br/>
                
                <label for="State">State </label>
                <input name="state" value= {user.state} onChange={onChange} type="text" /><br/>
                
                <label for="Zipcode">Zipcode </label>
                <input name="zipcode" value= {user.zipcode} onChange={onChange} type="text" /><br/>

                <div className="form-group">
                        <button type="submit" onClick={onSubmit} className="btn btn-primary">Update</button>
                </div>
            
        </div>
    )
}

export default ChangeInformation