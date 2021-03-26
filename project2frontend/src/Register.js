import React, { Component } from 'react';
import './Register.css';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
import UserServices from './services/UserServices';

{/* Register! */ }
class Register extends Component {

    constructor(props) {
        super(props)

        this.state = {
            id: '',
            firstName: '',
            lastName: '',
            emailId: '',
            password: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);

    }
    saveUser = (e) => {
        e.preventDefault();
        
        let user = { firstName: this.state.firstName, lastName: this.state.lastName, emailId: this.state.emailId, password: this.state.password };
        
        {/* Display the user in JSON in the console */ }
        console.log('User => ' + JSON.stringify(user));
        
        {/* Calls User Services to create the user */ }
        UserServices.createUser(user).then(res =>{
            this.props.history.push('./');
        });
    }
    changeFirstNameHandler = (event) => {
        this.setState({ firstName: event.target.value });
    }

    changeLastNameHandler = (event) => {
        this.setState({ lastName: event.target.value });
    }

    changeEmailHandler = (event) => {
        this.setState({ emailId: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
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

                        <h5>Enter your email</h5>
                        <input type='text' placeholder="Email Address" name="emailId" className="form-control"
                            value={this.state.emailId} onChange={this.changeEmailHandler} />

                        <h5>Enter a password</h5>
                        <input type='text' placeholder="Password" name="password" className="form-control"
                        />

                        <h5>Confirm password</h5>
                        <input type='text' placeholder=" Confirm Password" name="password" className="form-control"
                            value={this.state.password} onChange={this.changePasswordHandler} />


                        <button type='submit' className='login__signInButton' onClick={this.saveUser} >Register</button>

                    </form>
                </div>
            </div>

        )
    }
}
export default Register;