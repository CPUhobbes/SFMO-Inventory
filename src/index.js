import React from 'react';
import {render} from 'react-dom';
import {hashHistory} from 'react-router';
import {createStore, combineReducers} from 'redux';
import {Provider} from 'react-redux';
import Routes from './views/config/routes'
import {syncHistoryWithStore, routerReducer} from 'react-router-redux';

import * as reducers from './views/reducers/';

let store=createStore(
  combineReducers({
    ...reducers,
    routing: routerReducer
  })
);

const history = syncHistoryWithStore(hashHistory, store);
  

render(
  <Provider store={store}>
    <Routes history={history} />
  </Provider>,
  document.getElementById('root')
);
