import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import imsLogo from './imsLogo.png';
import {withRouter} from "react-router-dom";


class Main extends Component {

    constructor(props) {
        super(props);
        this.routeChange = this.routeChange.bind(this);
        this.addProduct = this.addProduct.bind(this)
    }

    routeChange() {
        let path = '/';
        this.props.history.push(path);
    }

    addProduct() {
        let path = '/IMS/product';
        this.props.history.push(path);
    }

    render() {
        if (localStorage.getItem('token') == null)
            this.routeChange();
        return (
            <MuiThemeProvider>
                <div>
                    <img src={imsLogo} className="App-logo" alt="logo"/>
                </div>
                <div>
                    <RaisedButton label="Search" primary={true} style={style}
                                  onClick={(event) => this.handleClick(event)}/>
                </div>
                <div>
                    <RaisedButton label="Add Product" primary={true} style={style} onClick={this.addProduct}/>
                </div>
                <div>
                    <RaisedButton label="Add Bundle" primary={true} style={style}
                                  onClick={(event) => this.handleClick(event)}/>
                </div>
                <div>
                    <RaisedButton label="View Global Inventory Statistics" primary={true} style={style}
                                  onClick={(event) => this.handleClick(event)}/>
                </div>
                <div>
                    <RaisedButton label="Create Account" primary={true} style={style}
                                  onClick={(event) => this.handleClick(event)}/>
                </div>
                <div>
                    <RaisedButton label="Logout" primary={true} style={style}
                                  onClick={(event) => this.handleClick(event)}/>
                </div>
            </MuiThemeProvider>
        );
    }


}

const style = {
    margin: 15
};


export default withRouter(Main);