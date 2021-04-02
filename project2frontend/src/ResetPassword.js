import React, { Component } from 'react'
import UserServices from './services/UserServices'
import './ResetPassword.css';
import { Link } from "react-router-dom";
import Logo from './logo.jpg';

{/* Reset Password! */ }

class ResetPassword extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            password: '',
        }
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.updatePassword = this.updatePassword.bind(this);
    }

    componentDidMount(){
        UserServices.getUserById(this.state.id).then((res) =>{
            let user = res.data;
            this.setState({password: user.password});
        });
    }

    updatePassword = (e) => {
        e.preventDefault();
        let user = {password: this.state.password};
        console.log('New Password => ' + JSON.stringify(user));
        console.log('User id => ' + JSON.stringify(this.state.id));
        UserServices.updateUser(user, this.state.id).then( res => {
            this.props.history.push('/login');
        });
    }
    
    changePasswordHandler = (event) => {
        this.setState({ password: event.target.value });
    }

    render() {
        return (
            <div className='reset'>
                <Link to='./login'>
                    <img className='logo_login'
                        src={Logo} alt='logo' />
                </Link>

                <div className='login__container'>
                    <h1>Update Password!</h1>

                    <form>

                        <h5>Enter a password</h5>
                        <input type='text' placeholder="Password" name="password" className="form-control"
                        />

                        <h5>Confirm password</h5>
                        <input type='text' placeholder=" Confirm Password" name="password" className="form-control"
                            value={this.state.password} onChange={this.changePasswordHandler} />

                        <button type='submit' className='login__updateButton' onClick={this.updatePassword} >Change password</button>

                    </form>
                </div>
            </div>

        )
    }
}

export default ResetPassword;