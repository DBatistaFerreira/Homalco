import React, {Component} from 'react';
import './App.css';
import Login from "./Login";
import Main from "./Main";
import Product from "./Product";

function App() {
  return (
    <div className="App">
        <Login/>
        <Main/>
        <Product/>
    </div>
  );
}

export default App;
