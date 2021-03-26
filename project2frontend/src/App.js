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

          <Route path="/">
            <Login />
          </Route>

        </Switch>
      </div>
    </Router>
  );
}

export default App;
