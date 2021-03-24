import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Header from './Header';
import Home from './Home';
import Login from './Login';
import Register from './Register';

function App() {
  return (
    <Router>
      <div className="app">
        <Switch>
          <Route path="/orders">
            <Header />
          
          </Route>

          <Route path="/checkout">
            <Header />
            <h1>Checkout</h1>
          </Route>

          <Route path="/login">
            <Login />
          </Route>
          <Route path="/register">
            <Register />
          </Route>

          <Route path="/">
            <Header />
            <Home />
          </Route>

        </Switch>
      </div>
    </Router>
  );
}

export default App;
