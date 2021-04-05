import React, { Component } from 'react';
import './Register.css';
import { Link,withRouter } from "react-router-dom";
import Logo from './logo.jpg';
import UserServices from './services/UserServices';

{/* Register! */ }
class Register extends Component {

    constructor() {
        super()

        this.state = {
            id: '',
            firstName: '',
            lastName: '',
            username: '',
            emailId: '',
            streetName: '',
            city: '',
            state: '',
            zipcode: '',
            password: '',
            userType: ''
        };

        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.changeStreetHandler = this.changeStreetHandler.bind(this);
        this.changeCityHandler = this.changeCityHandler.bind(this);
        this.changeStateHandler = this.changeStateHandler.bind(this);
        this.changeZipCodeHandler = this.changeZipCodeHandler.bind(this);
        this.changeUserHandler = this.changeUserHandler.bind(this);

    }

    saveUser = (e) => {
        e.preventDefault();

        let user = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            username: this.state.username,
            email: this.state.emailId,
            streetName: this.state.streetName,
            city: this.state.city,
            state:this.state.state,
            zipcode: this.state.zipcode,
            password: this.state.password,
            userType: this.state.userType === '' ? 'CUSTOMER' : this.state.userType
        };

        {/* Display the user in JSON in the console */ }
        console.log('User => ' + JSON.stringify(user));

        {/* Calls User Services to create the user */ }
        UserServices.createUser(user).then(res => {
            this.props.history.push('/login');
        });
    }


    changeFirstNameHandler = (event) => {
        this.setState({ firstName: event.target.value });
    }
    changeLastNameHandler = (event) => {
        this.setState({ lastName: event.target.value });
    }
    changeUsernameHandler = (event) => {
        this.setState({ username: event.target.value });
    }
    changeEmailHandler = (event) => {
        this.setState({ emailId: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }
    changeStreetHandler = (event) => {
        this.setState({ streetName: event.target.value });
    }
    changeCityHandler = (event) => {
        this.setState({ city: event.target.value });
    }
    changeStateHandler = (event) => {
        this.setState({ state: event.target.value });
    }
    changeZipCodeHandler = (event) => {
        this.setState({ zipcode: event.target.value });
    }
    changeUserHandler = (event) => {
        this.setState({ userType: event.target.value });
    }

    render() {
        return (
            <div className='register'>
                <Link to='./login'>
                    <img className='logo_login'
                        src={Logo} alt='logo' />
                </Link>

                <div className='login__container'>
                    <h1>Registation!</h1>

                    <form>
                        <h5>Enter your First name</h5>
                        <input type='text' placeholder="First Name" name="firstName" className="form-control"
                            value={this.state.firstName} onChange={this.changeFirstNameHandler} />

                        <h5>Enter you Last name</h5>
                        <input type='text' placeholder="Last Name" name="lastName" className="form-control"
                            value={this.state.lastName} onChange={this.changeLastNameHandler} />

                        <h5>Enter a username</h5>
                        <input type='text' placeholder="Username" name="username" className="form-control"
                            value={this.state.username} onChange={this.changeUsernameHandler} />

                        <h5>Enter your email</h5>
                        <input type='text' placeholder="Email Address" name="emailId" className="form-control"
                            value={this.state.emailId} onChange={this.changeEmailHandler} />

                        <h5>Enter your street address</h5>
                        <input type='text' placeholder="Street Address" name="streetname" className="form-control"
                            value={this.state.statename} onChange={this.changeStreetHandler} />

                        <h5>Enter your city</h5>
                        <input type='text' placeholder="City" name="city" className="form-control"
                            value={this.state.city} onChange={this.changeCityHandler} />

                        <h5>Enter your state</h5>
                        <input type='text' placeholder="State" name="state" className="form-control"
                            value={this.state.state} onChange={this.changeStateHandler} />

                        <h5>Enter your zip code</h5>
                        <input type='text' placeholder="Zip code" name="zipcode" className="form-control"
                            value={this.state.zipcode} onChange={this.changeZipCodeHandler} />

                        <h5>Enter a password</h5>
                        <input type='text' placeholder="Password" name="password" className="form-control"
                        />

                        <h5>Confirm password</h5>
                        <input type='text' placeholder=" Confirm Password" name="password" className="form-control"
                            value={this.state.password} onChange={this.changePasswordHandler} />

                        <select value={this.state.userType} onChange={this.changeUserHandler}>
                            <option value="Customer">Customer</option>
                            <option value="Manager">Manager</option>
                        </select>

                        <button type='submit' className='login__signInButton' onClick={this.saveUser} >Register</button>

                    </form>
                </div>
            </div>

        )
    }
}
export default withRouter(Register);