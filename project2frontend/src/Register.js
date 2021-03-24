import React from 'react';
import './Register.css';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
{/* Register! */}
function Register() {

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
                    <input type='text' />

                    <h5>Enter you Last name</h5>
                    <input type='text' />

                    <h5>Enter your email</h5>
                    <input type='text' />

                    <h5>Enter a password</h5>
                    <input type='text' />

                    <h5>Confirm password</h5>
                    <input type='text' />
                    <select className="dropdown">
                        <option value="Customer">Customer</option>
                        <option value="Driver">Driver</option>
                    </select>

                    <button type='submit' className='login__signInButton' onClick="/register" >Register</button>

                </form>
            </div>
        </div>

    )

}
export default Register;