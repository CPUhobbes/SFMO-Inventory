//Import Packages
import React, { Component } from 'react';
import {connect} from 'react-redux';
import { Row, Col, Button, Grid} from 'react-bootstrap';
import {Link} from 'react-router';

//Actions
//import * as actions from '../../actions/';

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

	}
	
	handleFormChange(event){
		console.log(event.target.id, event.target.value);
	}

	render(){
		//const {} = this.props;

		return (
			
			<div>
				<Grid>
					<Row>
						<Col sm={12}>
							<h2 className="text-center">Main Menu </h2>
						</Col>
					</Row>
					<Row>
						<Col sm={3} smOffset={1}>
							<Link to="/Inspections"><Button bsSize='large' bsStyle='primary'>Inspections</Button></Link>
						</Col>
						<Col sm={3}>
							<Link to="/Investigations"><Button bsSize='large' bsStyle='primary'>Investigations</Button></Link>
						</Col>
						<Col sm={3}>
							<Link to="/Licensing"><Button bsSize='large' bsStyle='primary'>Licensing</Button></Link>
						</Col>
					</Row>
					<Row>
						<Col sm={3} smOffset={1}>
							<Link to="/K9"><Button bsSize='large' bsStyle='primary'>K9 Investigations</Button></Link>
						</Col>
						<Col sm={3}>
							<Link to="/Clothing"><Button bsSize='large' bsStyle='primary'>Clothing</Button></Link>
						</Col>
						<Col sm={3}>
							<Link to="/Miscellaneous"><Button bsSize='large' bsStyle='primary'>Miscellaneous</Button></Link>
						</Col>
					</Row>
				</Grid>

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
	
});

export default connect(mapStateToProps, mapDispatchToProps)(Home);

//TESTING
// export default connect(
// 	state => (
// 		mapStateToProps),
// 	{addToCart, removeFromCart})(Home);