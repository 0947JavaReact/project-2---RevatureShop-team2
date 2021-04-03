import React, {useState,useEffect} from 'react';
import './ChangeInformation.css';
import USPS from 'usps-webtools'
import UserServices from '../services/UserServices' 


//allow user to change firstname, lastname, street address, city, state, zipcode
//address will be validated, if not 
function ChangeInformation(props){
    let [user, setUser] = useState({username:'',password:'',firstName:'',lastName:'',email:'',userType:1,streetName:'',city:'',state:'',zipcode:'',userId:''});
  
    useEffect(() => {
        const fetchData = async () => {
            UserServices.getUserById(6).then(res => {
            setUser({username:res.data.username,password:res.data.password,firstName:res.data.firstName,lastName:res.data.lastName,email:res.data.email,streetName:res.data.streetName,city:res.data.city,state:res.data.state,zipcode:res.data.zipcode,userId:res.data.userId})
       })}
        fetchData();
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
                setUser({ ...user,streetName:address.street1,city:address.city,zipcode:address.zip,state:address.state}) 
                UserServices.updateUserAddress(user,user.userId)
                alert("User information updated correctly")
            }
          });
          
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