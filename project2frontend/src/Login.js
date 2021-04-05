import React, { Component } from 'react';
import './Login.css';
import Logo from "./logo.jpg";
import { Link,Redirect, withRouter } from 'react-router-dom';
import UserServices from './services/UserServices';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';

import {loginUser} from './actions/userActions'


{/*Login page */ }
class Login extends Component {

    constructor(props) {
        super(props)

        this.state = {
            user: [],
            emailId: '',
            password: ''
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
   
    }
    componentWillReceiveProps(nextProps) {
        this.setState({user:nextProps})
        if (nextProps.loggedUser.userType == "MANAGER") {
            console.log(nextProps.loggedUser.userType)
            this.props.history.push('/add_new_item')
        } else if (nextProps.loggedUser.userType == "CUSTOMER") {
            console.log(nextProps.loggedUser.userType)
             this.props.history.push('/store_catalogue')
        }
        else{
            alert("wrong Info. Try again")
            window.location.reload(true);
        }
      }
    checkUser = (e) => {
        e.preventDefault();
        let user = { emailId: this.state.emailId, password: this.state.password };
        this.props.loginUser(user);
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
                <div className='login__container'>
                    <h1>Sign-in</h1>

                    <form>
                        <h5>E-mail</h5>
                        <input type='text' name="emailId" className="form-control"
                            value={this.state.emailId} onChange={this.changeEmailHandler} required />

                        <h5>Password</h5>
                        <input type='password' name="password" className="form-control"
                            value={this.state.password} onChange={this.changePasswordHandler} required />

                        <button type='submit' className='login__signInButton' onClick={this.checkUser} > Sign In</button>
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
Login.propTypes = {
    loginUser:PropTypes.func.isRequired,
    loggedUser: PropTypes.object.isRequired
}

const mapStateToProps = state => ({
    loggedUser: state.user.Loggeduser
  });
export default withRouter(connect(mapStateToProps, { loginUser })(Login));