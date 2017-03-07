import React, { Component } from 'react';
import {connect} from 'react-redux';
import { Row, Col, Image, Form, FormControl, FormGroup, InputGroup, Button, Glyphicon, ControlLabel} from 'react-bootstrap';
import inventoryList from '../../../../server/api/inventory';
//import PeopleContainer from './People/PeopleContainer';
//import {Provider} from 'react-redux';
//import configureStore from '../store/configure-store';
import {addToCart} from '../../actions/'



function Home({cart, increase}){
		console.log(cart)

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
							<Button onClick={()=> increase(1)}>Add To Cart </Button>
						</Col>
					</FormGroup>
				</Form>
      		</div>
		);
	}


export default connect(
	state => ({cart:state}),
	{addToCart}

)(Home);