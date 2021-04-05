import React, { Component } from 'react'
import {logoutUser} from './actions/userActions'
import { Link,withRouter} from "react-router-dom";
import { connect } from 'react-redux';
class Logout extends Component {
  constructor(props) {
    super(props)
    this.logout = this.logout.bind(this);
  }
  logout = () => {
    this.props.logoutUser()
  }
  
  render() {
    return (
      <button onClick={this.logout}>Logout</button>
    )
  }
}

export default withRouter(connect(null, { logoutUser })(Logout));