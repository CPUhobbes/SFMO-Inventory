"use strict";

//Packages
const express = require('express'),
	Index = require('../../src/controllers/indexController'),
	Router = express.Router();

//Index Route
Router.get('/', Index.loadIndex);

//API Routes
Router.get('/api/', (req,res) => {

	res.json({itWorks:"cool"});

})

module.exports = Router;
