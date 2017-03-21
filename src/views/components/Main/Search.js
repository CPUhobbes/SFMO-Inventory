//Import Packages
import React, { Component,  } from 'react';
import ReactDOM from "react-dom";
import {connect} from 'react-redux';
import { Col, Form, FormGroup, Button, Grid} from 'react-bootstrap';

//Controllers
//import Inventory from '../../../controllers/inventoryController';

//Actions
import * as actions from '../../actions/';

//Children Components
import TabMenu from './ItemChild/TabMenu';

//Helper functions
import Helpers from './../Helpers/helpers';

//TESTING
//import {addToCart, removeFromCart} from '../../actions/'

class Search extends Component{
	constructor(props) {
		super(props);

		this.state = {
			searchTerm:"",
			results:[],
			formData:[]
		};

		//Bind functions here
		this.handleFormSubmit= this.handleFormSubmit.bind(this);
		this.handleFormChange = this.handleFormChange.bind(this);
  	}

	componentWillMount(){

		this.setState({searchTerm: this.props.search.Search}, () =>{
		});
		
	}

	componentDidMount(){

	}

	componentDidUpdate(prevProps, prevState){

		//Update search if on Search Component
		if(prevState.searchTerm !== this.props.search.Search){
			this.setState({searchTerm: this.props.search.Search});
			
		}
	}

	componentWillUnmount(){

		//Reset Search 
		const {updateSearch} = this.props;
		updateSearch('');
		this.setState({searchTerm: ''});
	}
	
	handleFormSubmit(event){
		event.preventDefault();
		this.state.formData.forEach((value, index) => {
			this.props.addToCart(value.id, value.name, value.quantity);
		});

		//Reset state
		this.setState({
			formData: []
		});
		//Reset form
		ReactDOM.findDOMNode(this.refs.form).reset();
    	

		
	}
	
	handleFormChange(event){
		let updateItem = {id: event.target.id, name: event.target.name, quantity: parseInt(event.target.value, 10)}; 
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
	} 

	render(){

		const results = Helpers.findItemByName(this.state.searchTerm);
		
		return (		
			<div>
				<h2 className="text-center">Search Results</h2>
				<Form ref="form" horizontal onChange={this.handleFormChange} onSubmit={this.handleFormSubmit}>
					<Grid>
				 		<TabMenu items={results} menuName="search" />
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
	addToCart(id, name, quantity){
		dispatch(actions.addToCart(id, name, quantity))
	},
});


export default connect(mapStateToProps, mapDispatchToProps)(Search);
