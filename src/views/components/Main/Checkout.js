//Import Packages
import React, { Component,  } from 'react';
//import ReactDOM from "react-dom";
import {connect} from 'react-redux';
//import { Row, Col, Form, FormGroup, Button, Tabs, Tab, Grid} from 'react-bootstrap';

//Controllers
//import Inventory from '../../../controllers/inventoryController';

//Actions
import * as actions from '../../actions/';

//Children Components
//import InventoryItem from './ItemChild/item';

//Helper functions
//import Helpers from './../Helpers/helpers';

//TESTING
//import {addToCart, removeFromCart} from '../../actions/'

class Checkout extends Component{
	constructor(props) {
		super(props);

		this.state = {
			formData:[]
		};

		//Bind functions here
		
  	}
	
	handleFormSubmit(event){

		
    	

		
	}
	
	handleFormChange(event){
		
	} 


		
	

	render(){

		const {shoppingCart} = this.props;
		const checkoutCart = shoppingCart.cart;
		
		return (		
			<div>
				<h2 className="text-center">Checkout</h2>
				{checkoutCart.map((item, index) => {
					return(<div key={index}>{item.id+" --- "+item.name+" --- "+item.quantity}</div>);


				})}


      		</div>
		);
	}
}

//Redux
const mapStateToProps = (state) =>{
	return{
		shoppingCart:state.Shopping_Cart,
		search:state.Search
	}
}

const mapDispatchToProps = (dispatch) => ({
	updateSearch(value){
		dispatch(actions.updateSearch(value))
	},
});


export default connect(mapStateToProps, mapDispatchToProps)(Checkout);
