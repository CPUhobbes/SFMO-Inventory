//Import Packages
import React, { Component,  } from 'react';
import ReactDOM from "react-dom";
import {connect} from 'react-redux';
import { Row, Col, Form, FormGroup, Button, Tabs, Tab, Grid} from 'react-bootstrap';

//Controllers
import Inventory from '../../../controllers/inventoryController';

//Actions
import * as actions from '../../actions/';

//Children Components
import InventoryItem from './ItemChild/item';

//Helper functions
import Helpers from './../Helpers/helpers';

//TESTING
//import {addToCart, removeFromCart} from '../../actions/'

class Home extends Component{
	constructor(props) {
		super(props);

		this.state = {
			formData:[]
		};

		//Bind functions here
		this.handleFormSubmit= this.handleFormSubmit.bind(this);
		this.handleFormChange = this.handleFormChange.bind(this);
  	}
	
	handleFormSubmit(event){

		event.preventDefault();
		this.state.formData.forEach((value, index) => {
			this.props.addToCart(value.id,value.quantity);
		});

		//Reset state
		this.setState({
			formData: []
		});
		//Reset form
		ReactDOM.findDOMNode(this.refs.form).reset();
    	

		
	}
	
	handleFormChange(event){
		let updateItem = {id: event.target.id, quantity: parseInt(event.target.value)}; 
		let data = this.state.formData;
		let position = Helpers.findItemByID(event.target.id, this.state.formData);

		if(position>=0){
			data[position]=updateItem;
			this.setState({
				formData: data
			});
		}
		else{
			data.push(updateItem);
			this.setState({
				formData: data
			});
		}
		
		//console.log(this.state.formData);
		//console.log(event.target.id, event.target.value);
	} 

	renderItems(){

		//Non Mutating
		let inventoryDB = Inventory.getInventory();
		let inventoryList = inventoryDB.inventory.licencing;
		let inventoryChunck = Math.ceil(inventoryList.length/10)
		let splitArr = [];

		//Split into 10 piece chuncks
		for(let i=0;i<inventoryChunck-1;++i){
			splitArr.push(inventoryList.slice(i*10,(i+1)*10));
		}

		//Push remainder
		splitArr.push(inventoryList.slice(10*(inventoryChunck-1)));
		//console.log(splitArr);

		return(
			<div>
				<Tabs defaultActiveKey={1} id="licencing_tab">
					{splitArr.map((itemTab,indexTab)=>{
						return( 
							<Tab key={indexTab} eventKey={indexTab+1} title={"Page "+(indexTab+1)}>
								<Grid>
									{itemTab.map((itemPart, indexPart) =>{
										return(
											<Row key={indexPart}>												
												<InventoryItem item={itemPart} />
											</Row>
										);
									})}
								</Grid>
							</Tab>
						);	
					})}
				</Tabs>
			</div>
		);
	}
	

	render(){
		
		return (		
			<div>
				<h2 className="text-center">Inspections</h2>
				<Form ref="form" horizontal onChange={this.handleFormChange} onSubmit={this.handleFormSubmit}>
					<Grid>
					{this.renderItems()}

					<FormGroup>
						<Col sm={12}>
							<div className="text-center"><Button type="submit" bsStyle="primary">Add To Cart</Button></div>
							
						</Col> 
					</FormGroup>
					</Grid>
				</Form>		
      		</div>
		);
	}
}
const mapStateToProps = (state) =>{
	return{
		cart:state
	}
}

const mapDispatchToProps = (dispatch) => ({
	addToCart(item, quantity){
		dispatch(actions.addToCart(item, quantity))
	},
	removeFromCart(item, quantity){
		dispatch(actions.removeFromCart(item, quantity))
	},
});

export default connect(mapStateToProps, mapDispatchToProps)(Home);

//TESTING
// export default connect(
// 	state => (
// 		mapStateToProps),
// 	{addToCart, removeFromCart})(Home);