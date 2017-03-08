import React, { Component} from 'react';
import {Row, Col, Image, Form, FormControl, FormGroup, InputGroup, Button, Glyphicon, Nav, Navbar, NavItem, Badge} from 'react-bootstrap';
import {IndexLinkContainer} from 'react-router-bootstrap';
import {Link} from 'react-router';
import {connect} from 'react-redux';
import * as actions from '../actions/';

class Index extends Component {

	// constructor(props){
	// 	super(props);
	// 	this.state={

	// 		search:"",
	// 		itemCount:0
	// 	}

	// }


	render() {

		const {shoppingCart, search, updateSearch} = this.props;
		console.log(shoppingCart, search);
		//let numItems = 0;
		let numItems = shoppingCart.cart.length;
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
				    						<Link to="/Checkout" className="hidden_lg"><Badge>Checkout <Glyphicon glyph="shopping-cart" /> {numItems}</Badge></Link>
				    			</Navbar.Text>
				    		</Navbar.Header>
				    		
				    		<Navbar.Collapse>
				    			<Navbar.Text pullRight>
				    						<Link to="/Checkout" className="hidden_sm"><Badge>Checkout <Glyphicon glyph="shopping-cart" /> {numItems}</Badge></Link>
				    			</Navbar.Text>
				    			<Navbar.Text pullRight> 
				    						<Link to="/Login"> Log In</Link>
				    			</Navbar.Text>
				    			<Nav>
				    				<IndexLinkContainer to={"#"} activeHref="active">
					    				<NavItem eventKey={1} >Home</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Inspections"} >
					    				<NavItem eventKey={2} >Inspections</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Investigations"} >
					    				<NavItem eventKey={3} >Investigations</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Licensing"} >
					    				<NavItem eventKey={4} >Licensing</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/K9"} >
					    				<NavItem eventKey={5} >K9</NavItem>
					    			</IndexLinkContainer>
					    			<IndexLinkContainer to={"/Clothing"}>
					    				<NavItem eventKey={6} >Clothing</NavItem>
					    			</IndexLinkContainer>
									<IndexLinkContainer to={"/Miscellaneous"}>
					    				<NavItem eventKey={7} >Misc</NavItem>
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


export default connect(mapStateToProps, mapDispatchToProps)(Index);

