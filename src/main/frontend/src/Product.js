import React, {Component} from 'react';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import imsLogo from './imsLogo.png';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import {TypeBackground as classes} from "@material-ui/core/styles/createPalette";
import Typography from "@material-ui/core/Typography/Typography";
import TextField from "@material-ui/core/TextField/TextField";

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

    constructor(props){
        super(props);
        this.state={
            name: '',
            description: '',
            marketPrice: '',
            category: ''
        }
    }

    render() {
        return (
            <MuiThemeProvider>
                <div>
                    <img src={imsLogo} className="App-logo" alt="logo" />
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
                        <TextField id="outlined-basic" label="Name" variant="outlined" />
                    </Grid>
                    <Grid item xs={6}>
                            <RaisedButton label="Activate Product" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Category:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="outlined-basic" label="Category" variant="outlined" />
                    </Grid>
                    <Grid item xs={6}>
                        <RaisedButton label="Add Timestamp" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Description:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="outlined-basic" label="Description" variant="outlined" />
                    </Grid>
                    <Grid item xs={6}>
                    </Grid>
                    <Grid item xs={3}>
                        <Typography variant="h5" component="h3">
                            Market Price:
                        </Typography>
                    </Grid>
                    <Grid item xs={3}>
                        <TextField id="outlined-basic" label="Market Price" variant="outlined" />
                    </Grid>
                    <Grid item xs={6}>
                    </Grid>
                    <Grid item xs={12}>
                        <RaisedButton label="Save" primary={true} style={style} onClick={(event) => this.handleClick(event)}/>
                    </Grid>
                </Grid>

            </MuiThemeProvider>
        );
    }
}

const style = {
    margin: 15
};


export default Product;