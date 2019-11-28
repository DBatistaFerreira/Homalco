import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import imsLogo from './imsLogo.png';
import axios from 'axios';

class Login extends Component {

    constructor(props){
        super(props);
        this.login = this.login.bind(this);
        this.state={
            username:'',
            password:''
        }
    }
    render() {
        return (
            <div>
                <MuiThemeProvider>
                    <div>
                        <img src={imsLogo} className="App-logo" alt="logo" />
                    </div>
                    <div>
                        <TextField
                            hintText="Enter your Username"
                            floatingLabelText="Username"
                            onChange = {(event,newValue) => this.setState({username:newValue})}
                            id = 'name'
                        />
                        <br/>
                        <TextField
                            type="password"
                            hintText="Enter your Password"
                            floatingLabelText="Password"
                            id='pass'
                            onChange = {(event,newValue) => this.setState({password:newValue})}
                        />
                        <br/>
                        <RaisedButton label="Sign In" primary={true} style={style} onClick={this.login}/>
                    </div>
                </MuiThemeProvider>
            </div>
        );
    }


    login() {
        let name;
        let pass;
        let element;
        element = document.getElementById('name');
        if (element != null) {
            name = element.value;

        }
        else {
            name = null;
        }
        element = document.getElementById('pass');
        if (element != null) {
            pass = element.value;
        }
        else {
            pass = null;
        }

        axios.post('http://localhost:8080/login', {
            username: name,
            password: pass
        }).then(res => {
            console.log(res.headers.get('authorization'));
            if (this.state.loggedIn === true) {
                //alert("logged in"); // login returns true
                this.props.history.push("/IMS/");
            }
        }, err => {
            alert("Server rejected response: " + err);
        });

    }
}
const style = {
    margin: 15,
};
export default Login;