//PACKAGES
import React from 'react';
import {Router, Route, IndexRoute} from 'react-router';

//COMPONENTS
import Index from '../components/index';
import Home from '../components/Main/Home';
import Inspections from '../components/Main/Inspections';
import NotFound from '../components/Error/NotFound';


const Routes = (props) => (
	<Router {...props}>
		<Route path="/" component={Index}>
			<IndexRoute component={Home} />
			<Route path="/Inspections" component={Inspections} />
		</Route>
		<Route path="/Login" component={NotFound} />
		<Route path="*" component={NotFound} />
	</Router>

);

export default Routes;