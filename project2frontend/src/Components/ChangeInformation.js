import React, {useState} from 'react';
import { Route } from 'react-router';
import './ChangeInformation.css';

//allow user to change firstname, lastname, street address, city, state, zipcode
//address will be validated, if not 
function ChangeInformation(props){
    let [user, setUser] = useState({username:'testUser',password:'testPass',firstName:'testFirst',lastName:'testLast',email:'test@test.com',userType:1,streetName:'11730 Plaza America Dr',city:'reston',state:'VA',zipcode:'20190'});
   
    function onSubmit(){
        alert("submitted")
    }
    const onChange = (e) => {
        setUser({ ...user,[e.target.name]: e.target.value}) 
    }
    return(
        <div>
            <div>Update information Page</div>
            <p>allow user to change firstname, lastname, street address, city, state, zipcode
            <br/>address will be validated using api.
            <br/>if address is invalid then reject changes
            <br/>users will be routed back to CustomerInformation with an alert that tells the user that the address is invalid</p>
            
            <form onSubmit={onSubmit}>
                <h1>Update Information </h1>
                <h6>*You cannot change your Username or your email*</h6>
                <label for="UserName" >Username </label>
                <input name="UserName" value= {user.username} onChange={onChange} id="username" readOnly/><br/>
                
                <label for="Email" >Email </label>
                <input name="Email" value= {user.email} onChange={onChange} id="email" readOnly/><br/>
                
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
                        <button type="submit" className="btn btn-primary">Update</button>
                </div>
            </form>
        </div>
    )
}

export default ChangeInformation