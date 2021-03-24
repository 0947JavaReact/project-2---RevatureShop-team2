import React from 'react';
import './ForgotPassword.css';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';
{/* Register! */}
function ForgotPassword() {

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
                    <input type='text' />

                    <button type='submit' className='reset_button' onClick="/login" >Send recovery email</button>

                </form>
            </div>
        </div>

    )

}
export default ForgotPassword;