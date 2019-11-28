import React, {Component} from 'react';
import './App.css';
import Login from "./Login";
import Main from "./Main";
import Product from "./Product";
import {BrowserRouter as Router, Route} from 'react-router-dom';

function App() {


  /*
    return (


      <div className="App">
          <Login/>
          <Main/>
          <Product/>
      </div>


    );

  */
  return (
      <Router key={0}>
      <div key={1} className="App">
      <p></p>
      <div  key={2} className="container">
      <Route key={3} exact path="/" render={props => (<React.Fragment><Login /></React.Fragment>)} />
  <Route key={4} exact path="/IMS" component={Main} />
  <Route key={5} path="/IMS/product" component={Product} />

  </div>
  </div>
  </Router>
);


}

export default App;
