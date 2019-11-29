import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import imsLogo from './imsLogo.png';
import {makeStyles} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import {TypeBackground as classes} from "@material-ui/core/styles/createPalette";
import Typography from "@material-ui/core/Typography/Typography";
import TextField from "@material-ui/core/TextField/TextField";
import {withRouter} from "react-router-dom";
import axios from "axios";

const useStyles = makeStyles(theme => ({
    root: {
        flexGrow: 1,
    },
    paper: {
        padding: theme.spacing(2),
        textAlign: 'center',
        color: theme.palette.text.secondary,
    },
}));

class Product extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            description: '',
            marketPrice: '',
            category: ''
        }
        this.routeChange = this.routeChange.bind(this);
        this.newProduct = this.newProduct.bind(this);
    }

    routeChange() {
        let path = '/';
        this.props.history.push(path);
    }


    render() {
        if (localStorage.getItem('token') == null)
            this.routeChange()
        return (
            <MuiThemeProvider>
                <div>
                    <img src={imsLogo} className="App-logo" alt="logo"/>
                </div>
                <Grid container spacing={3}>
                    <Grid item xs={12}>
                        <Paper/>
                        <Paper>
                            <Typography variant="h5" component="h3">
                                Product Interface
                            </Typography>
                        </Paper>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Name:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="name" label="Name" variant="outlined"/>
                    </Grid>
                    <Grid item xs={6}>
                        <RaisedButton label="Activate Product" primary={true} style={style}
                                      onClick={(event) => this.handleClick(event)}/>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Category:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="category" label="Category" variant="outlined"/>
                    </Grid>
                    <Grid item xs={6}>
                        <RaisedButton label="Add Timestamp" primary={true} style={style}
                                      onClick={(event) => this.handleClick(event)}/>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Description:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="description" label="Description" variant="outlined"/>
                    </Grid>
                    <Grid item xs={6}>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Market Price:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="marketPrice" label="Market Price" variant="outlined"/>
                    </Grid>
                    <Grid item xs={6}>
                    </Grid>
                    <Grid item xs={12}>
                        <RaisedButton label="Save" primary={true} style={style} onClick={this.newProduct}/>
                    </Grid>
                </Grid>

            </MuiThemeProvider>
        );
    }

    newProduct() {
        let name;
        let category;
        let description;
        let marketPrice;
        let element;
        element = document.getElementById('name');
        if (element != '') {
            name = element.value;
        } else {
            name = null;
        }
        element = document.getElementById('category');
        if (element != '') {
            category = element.value;
        } else {
            category = null;
        }
        element = document.getElementById('description');
        if (element != '') {
            description = element.value;
        } else {
            description = null;
        }
        element = document.getElementById('marketPrice');
        if (element != '') {
            marketPrice = element.value;
        } else {
            marketPrice = null;
        }
        if (name == '' || description == '' || category == '' || marketPrice == '') {
            alert("Please fill all mandatory fields.")
        }else {
            let token = localStorage.getItem('token')
            console.log(token);


            axios.post('http://localhost:8080/api/Products', {
                name: name,
                category: category,
                description: description,
                marketPrice: marketPrice
            }, {
                headers: {
                    Authorization: token
                }
            })
                .then(res => {
                    if (res.status == 201) {
                        alert('Successfully Created!')
                    }
                    if (res.status == 403) {
                        localStorage.setItem('token', 'null')
                        this.routeChange()
                    }
                }, err => {
                    alert("Server rejected response: " + err);
                });
        }
    }

}

const style = {
    margin: 15
};


export default withRouter(Product);