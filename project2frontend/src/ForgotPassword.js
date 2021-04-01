import React, { Component } from 'react';
import './ForgotPassword.css';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
{/* Forgot Password! */ }

class ForgotPassword extends Component {

    constructor(props) {
        super(props)

        this.state = {
            emailId: ''
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);

    }
    changeEmailHandler = (event) => {
        this.setState({ emailId: event.target.value });
    }

    sendEmail = (e) => {
        e.preventDefault();
        let email = { emailId: this.state.emailId};

        {/* Display the email in JSON in the console */ }
        console.log('Email => ' + JSON.stringify(email));

        {/* Calls User Services to send email to the user */ }
        UserServices.getEmail(emailId)
            .then(res => {
                    console.log(res.email);
                    this.props.history.push('./login');
                }
            );
    }

    render() {
        return (
            <div className='forgot'>
                <Link to='./login'>
                    <img className='logo_login'
                        src={Logo} alt='logo' />
                </Link>
                <div className='login__container'>
                    <h1>Password recovery</h1>

                    <form>
                        <h5>Enter your RevatureShop email</h5>
                        <p>
                            Once you have enter your RevatureShop email, you will recieve an email regarding your
                            password recovery.
                    </p>
                        <input type='text' placeholder = "Enter your email" name="emailId" className="form-control"
                            value={this.state.emailId} onChange={this.changeEmailHandler} required />

                        <button type='submit' className='reset_button' onClick={this.sendEmail} >Send recovery email</button>

                    </form>
                </div>
            </div>

        )

    }

}
export default ForgotPassword;