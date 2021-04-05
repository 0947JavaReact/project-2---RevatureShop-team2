import React from 'react';
import './App.css';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Login from './Login';
import Register from './Register';
import ForgotPassword from './ForgotPassword';
import ChangeInformation from './Components/ChangeInformation';
import CustomerInformation from './Components/CustomerInformation'
import ShowItems from './Store'
import NewItem from './AddItem';
import Logout from './Logout'
import ResetPassword from './ResetPassword'
import { Provider } from 'react-redux';
import store from './reduxStore';
import Header from './header'
import Checkout from './Checkout';

function App() {
  return (
    <Provider store = {store}>
    <Router>
      <Header />
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
          <Route path="/reset">
            <ResetPassword />
          </Route>
          <Route path="/ChangeInformation">
            <ChangeInformation />  
          </Route> 
          <Route path ="/CustomerInformation">
              <CustomerInformation />
          </Route>
          <Route path="/store_catalogue">
            <ShowItems/>
          </Route>
          <Route path="/add_new_item">
            <NewItem/>
          </Route>
          <Route path="/cart">
            <Checkout />
          </Route>
          <Route path="/">
            <Login />
          </Route>
        </Switch>
      </div>
    </Router>
    </Provider>
  );
}

export default App;