import React, { Component } from 'react';
import {connect} from 'react-redux';
import { Row, Col, Image, Form, FormControl, FormGroup, InputGroup, Button, Glyphicon, ControlLabel} from 'react-bootstrap';
import inventoryList from '../../../../server/api/inventory';
//import PeopleContainer from './People/PeopleContainer';
//import {Provider} from 'react-redux';
//import configureStore from '../store/configure-store';
//import {addToCart, removeFromCart} from '../../actions/'
import * as actions from '../../actions/';


class Home extends Component{

	render(){
		const {addToCart, removeFromCart} = this.props;

		return (
			
			<div>
				<Form horizontal>

					{inventoryList.lab_supplies[0].map(function(item, index){
						return (
							<div key={index}>
									<Row>
										<Col sm={12}>
											<FormGroup controlId={"control_"+item.nickname}>
												<Col sm={2}>
													{item.name}
												</Col>
												<Col sm={10}>
													<FormControl type="text" />
												</Col>
											</FormGroup>
										</Col>
									</Row>
							</div>
						);
					})}

					<FormGroup>
						<Col sm={12}>
							<Button onClick={()=> addToCart("test", 1)}>Add  </Button>
							<Button onClick={()=> removeFromCart("test", 5)}>Remove</Button>
							<Button onClick={()=> addToCart("tester", 7)}>Add to Cart</Button>
							
						</Col>
					</FormGroup>
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


// export default connect(
// 	state => (
// 		mapStateToProps),
// 	{addToCart, removeFromCart})(Home);