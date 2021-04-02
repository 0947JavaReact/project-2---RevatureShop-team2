import React, { Component } from 'react'


export default class Logout extends Component {

  logout = () => {
    window.localStorage.clear();
    window.location.href = "http://localhost:3000/login";
  }
  
  render() {
    return (
      <button onClick={this.logout}>Logout</button>
    )
  }
}