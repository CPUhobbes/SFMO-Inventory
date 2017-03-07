import React, { Component} from 'react';
import {Row, Col, Image, Form, FormControl, FormGroup, InputGroup, Button, Glyphicon, Nav, Navbar, NavItem, Badge} from 'react-bootstrap';
import {IndexLinkContainer} from 'react-router-bootstrap';
import {Link} from 'react-router';
import {connect} from 'react-redux';
import * as actions from '../actions/';

class Index extends Component {

	constructor(props){
		super(props);
		this.state={

			search:"",
			itemCount:0
		}

	}


	render() {

		const {cart, search, updateSearch} = this.props;
		console.log(cart, search);
		let numItems = 0;
		//let numItems = cart.Shopping_Cart.cart.length;
		//updateSearch("cool");

		
		return(
		  	<div>
				
				    <Row>
				      	<Col xs={12} md={6}>
				      		<p className="main_title"> <Image src="./images/sfmo_logo.jpg" width={100} /> SFMO Inventory </p>
				      	</Col>
				      	<Col xs={12} md={6}> 
				      		<div className="search_wrapper">
					      		<div className="search_box">
					      		<Form>
					      			<FormGroup>
					      				<InputGroup>
							      			<FormControl 
							      				type="text"
							      				value=""
							      				placeholder="Search"
							      				
							      			/>
							      			<InputGroup.Button>
							      				<Button onClick={()=> updateSearch("test")}><Glyphicon glyph="search" /></Button>
							      			</InputGroup.Button>
							      		</InputGroup>
					      			</FormGroup>
					      		</Form>
					      	</div>
				      		</div>
				      	</Col>
				    </Row>
				    
				    	<Navbar>
				    		<Navbar.Header>
				    			<Navbar.Brand>
				    				<a href="#" className="hidden_lg"><span><Image src="./images/sfmo_logo.jpg" width={25} /> SFMO Inventory</span></a>
				    			</Navbar.Brand>
				    			<Navbar.Toggle />
				    			<Navbar.Text pullRight>
				    						<a href="#" className="hidden_lg"><Badge><Glyphicon glyph="shopping-cart" /> {numItems}</Badge></a>
				    			</Navbar.Text>
				    		</Navbar.Header>
				    		
				    		<Navbar.Collapse>
				    			<Navbar.Text pullRight>
				    						<a href="#" className="hidden_sm"><Badge><Glyphicon glyph="shopping-cart" /> {numItems}</Badge></a>
				    			</Navbar.Text>
				    			<Navbar.Text pullRight> 
				    						<Link to="/Login"> Log In</Link>
				    			</Navbar.Text>
				    			<Nav>
				    				<IndexLinkContainer to={"#"} activeHref="active">
					    				<NavItem eventKey={1} >Home</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Link2"} >
					    				<NavItem eventKey={2} >Link 2</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Link3"} >
					    				<NavItem eventKey={3} >Link 3</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Link4"} >
					    				<NavItem eventKey={4} >Link 4</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Link5"} >
					    				<NavItem eventKey={5} >Link 5</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Link6"}>
					    				<NavItem eventKey={6} >Link 6</NavItem>
					    			</IndexLinkContainer>
					    			
					    		</Nav>
					    		
					    	</Navbar.Collapse>


					    		
					    			
					    		
					    	
					    </Navbar>


				    

				
				

				{/*Render component children, important!!*/}
				{this.props.children}
		  	

		  	</div> 
		);
  	}
}


const mapStateToProps = (state) =>{
	return{
		cart:state.Shopping_Cart,
		search:state.Search
	}
}

const mapDispatchToProps = (dispatch) => ({
	updateSearch(value){
		dispatch(actions.updateSearch(value))
	},
});


export default connect(mapStateToProps, mapDispatchToProps)(Index);

