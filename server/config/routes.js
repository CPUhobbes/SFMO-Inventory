"use strict";

//Packages
const express = require('express'),
	Index = require('../../src/controllers/indexController'),
	Router = express.Router();

//Index Route
Router.get('/', Index.loadIndex);

//API Routes



module.exports = Router;
