import React, { Component } from 'react';
import './Login.css';
import Logo from "./logo.jpg";
import { Link } from 'react-router-dom';
import UserServices from './services/UserServices';


{/*Login page */ }
<<<<<<< HEAD
function storeCatalogue(){        
    this.push('/store_catalogue/'); 
    // this.props.history.push('/store_catalogue');   
}
function Login() {
    return (
=======
class Login extends Component {
>>>>>>> Nathanael

    constructor(props) {
        super(props)

        this.state = {
            emailId: '',
            password: ''
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);

    }
    checkUser = (e) => {
        e.preventDefault();

<<<<<<< HEAD
                    <Link to="/store_catalogue" className="store_catalogue">
                        <button type='submit' className='login__signInButton' onClick={storeCatalogue}>Sign In</button>
                    </Link>
                </form>
=======
        let user = {emailId: this.state.emailId, password: this.state.password };

        {/* Display the user in JSON in the console */ }
        console.log('User => ' + JSON.stringify(user));

        {/* Calls User Services to create the user */ }
        UserServices.createUser(user).then(res => {
            this.props.history.push('/store');
        });
>>>>>>> Nathanael


    }

    changeEmailHandler = (event) => {
        this.setState({ emailId: event.target.value });
    }
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }
    render() {
        return (

            <div className='login'>
                <Link to='./login'>
                    <img className='logo_login'
                        src={Logo} alt='logo' />
                </Link>
<<<<<<< HEAD

                
            </div>
=======
                <div className='login__container'>
                    <h1>Sign-in</h1>
>>>>>>> Nathanael

                    <form>
                        <h5>E-mail</h5>
                        <input type='text' name="emailId" className="form-control"
                            value={this.state.emailId} onChange={this.changeEmailHandler} required />

                        <h5>Password</h5>
                        <input type='password' name="password" className="form-control"
                            value={this.state.password} onChange={this.changePasswordHandler} required />

                        <button type='submit' className='login__signInButton' onClick="/register" >Sign In</button>

                    </form>

                    <p>
                        When you sign in sign in, you are agreeing to the RevatureShop terms & conditions.
                </p>
                    <Link to="/forgot" className="forgot_password">
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
}
export default Login;
