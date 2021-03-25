import React, {useState} from 'react';
import { Route } from 'react-router';

//allow user to change firstname, lastname, street address, city, state, zipcode
//address will be validated, if not 
function ChangeInformation(props){
    onSubmit(e){
        alert("submitted");
        
    }
    return(
        <div>
            <div>Update information Page</div>
            <p>allow user to change firstname, lastname, street address, city, state, zipcode
            <br/>address will be validated using api.
            <br/>if address is invalid then reject changes
            <br/>users will be routed back to CustomerInformation with an alert that tells the user that the address is invalid</p>
            <form onSubmit={onSubmit}>
            <label for="UserName" >Username </label>
            <input name="UserName" value= {user.username} id="username" readOnly/><br/>
            
            <label for="Email" >Email </label>
            <input name="Email" value= {user.email} id="email" readOnly/><br/>
            
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
            <div className="form-group">
                    <input type="submit" value="Update account information" className="btn btn-primary" />
                </div>
            </form>
        </div>
    )
}

export default ChangeInformation