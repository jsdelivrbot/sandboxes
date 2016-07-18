var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var morgan = require('morgan');
var mongoose = require('mongoose');

//used to create, sign, and verify tokens
var jwt = require('jsonwebtoken');
//get our config file
var config = require('./config');
//get our mongoose model
var User = require('./app/models/user');

/*
Configuration
 */
var port = process.env.PORT || 8000;
//connect to database
mongoose.connect(config.database);
//secret variable
app.set('superSecret', config.secret);

//use body parser so we can get info from POST and/or URL parameters
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// use morgan to log requests to the console
app.use(morgan('dev'));

/*
Routes
 */

//basic route
app.get('/', function(req, res) {
    res.send('Hello! The API is at http://localhost:' + port + '/api');
});

//creates a default user
app.get('/setup', function(req, res) {

    //create a sample user
    var nick = new User({
        name: 'Nick Cerminara',
        password: 'password',
        admin: true
    });

    //save the user
    nick.save(function(err) {
        if (err) {
            throw err;
        }

        console.log('User saved successfully');
        res.json({ success: true });
    });
});

//API routes

//get an instance of the router for api routes
var apiRoutes = express.Router();

//route to authenticate a user (POST http://localhost:8080/api/authenticate)
apiRoutes.post('/authenticate', function(req, res) {

    User.findOne({
        name: req.body.name
    }, function(err, user) {
        if (err) {
            throw err;
        }

        if (!user) {
            res.json({ success: false, message: 'Authentication failed. User not found.' });
        } else if (user) {
            //check if password matches
            if (user.password != req.body.password) {
                res.json({ success: false, message: 'Authentication failed. Wrong password. '});
            } else {
                //create token if user/password is correct
                var token = jwt.sign(user, app.get('superSecret'), {
                    //expiresInMinutes: 1440
                });

                res.json({
                    success: true,
                    message: 'Enjoy your token!',
                    token: token
                });
            }
        }
    });
});

//route middleware to verify a token

//route to show a random message (GET http://localhost:8080/api/)
apiRoutes.get('/', function(req, res) {
    res.json({ message: 'Welcome to the coolest API on earth!' });
});

//route to return all users (GET http://localhost:8080/api/users)
apiRoutes.get('/users', function(req, res) {
    User.find({}, function(err, users) {
        res.json(users);
    });
});

//apply the routes to our application with the prefix /api
app.use('/api', apiRoutes);

//start the server
app.listen(port);
console.log('Magic happens at http://localhost:' + port);


