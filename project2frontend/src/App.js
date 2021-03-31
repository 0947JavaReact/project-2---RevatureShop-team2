import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from './Login';
import Register from './Register';
import Logout from './Logout';
import ForgotPassword from './ForgotPassword';

function App() {
  return (
    <Router>
      <div className="app">
        <Switch>
          <Route path="/forgot">
            <ForgotPassword />
          </Route>
          <Route path="/register">
            <Register />
          </Route>
          <Route path="/logout">
            <Logout />
          </Route>
          <Route path="/">
            <Login />
          </Route>

        </Switch>
      </div>
    </Router>
  );
}

export default App;
