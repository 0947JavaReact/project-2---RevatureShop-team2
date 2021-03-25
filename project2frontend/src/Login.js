import React from 'react';
import './Login.css';
import Logo from "./logo.jpg";
import { Link } from 'react-router-dom';
{/*Login page */}
function Login() {
    return (
         
        <div className='login'>
            <Link to = './'>
            <img className='logo_login'
                src={Logo} alt = 'logo' />
            </Link>
            <div className='login__container'>
                <h1>Sign-in</h1>

                <form>
                    <h5>E-mail</h5>
                    <input type='text' />

                    <h5>Password</h5>
                    <input type='password' />
                
                    <button type='submit' className='login__signInButton' onClick = "/register" >Sign In</button>
                    
                </form>

                <p>
                   You can now sign in!
                </p>
            
                <Link to ="/register" >
                <button className='login__registerButton'>Create your RevatureShop Account</button>
                </Link>
            </div>


        </div>

    )


}

export default Login;
