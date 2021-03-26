import React from 'react';
import './Login.css';
import Logo from "./logo.jpg";
import { Link } from 'react-router-dom';

{/*Login page */ }
function storeCatalogue(){        
    this.push('/store_catalogue/'); 
    // this.props.history.push('/store_catalogue');   
}
function Login() {
    return (

        <div className='login'>
            <Link to='./login'>
                <img className='logo_login'
                    src={Logo} alt='logo' />
            </Link>
            <div className='login__container'>
                <h1>Sign-in</h1>

                <form>
                    <h5>E-mail</h5>
                    <input type='text' />

                    <h5>Password</h5>
                    <input type='password' />

                    <Link to="/store_catalogue" className="store_catalogue">
                        <button type='submit' className='login__signInButton' onClick={storeCatalogue}>Sign In</button>
                    </Link>
                </form>

                <p>
                    When you sign in sign in, you are agreeing to the RevatureShop terms & conditions.
                </p>
                <Link to="/forgot" className = "forgot_password">
                    <div className="forgot_password">
                        <span className="statement">Forgot password?</span>
                    </div>
                </Link>


                <Link to="/register" >
                    <button className='login__registerButton'>Create your RevatureShop Account</button>
                </Link>

                
            </div>


        </div>

    )


}

export default Login;
