import React from 'react';
import ReactDOM from 'react-dom';
import {hashHistory} from 'react-router';

import Routes from './views/config/routes'

ReactDOM.render(
  <Routes history={hashHistory} />,
  document.getElementById('root')
);
