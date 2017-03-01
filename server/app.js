const express = require('express'),
	Routes = require('./config/routes'),
	BodyParser = require('body-parser'),
	Promise = require('bluebird'),
	Path = require('path'),
	Mongoose = require('mongoose');


//Express
const app = express();

app.use(BodyParser.json());
app.use(BodyParser.urlencoded({extended: false}));

app.use(express.static(Path.join(__dirname, '../build')));

app.use('/', Routes);

//Mongoose

module.exports = app;