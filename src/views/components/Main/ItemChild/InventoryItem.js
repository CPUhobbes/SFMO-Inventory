import React, { Component } from 'react';
import { Col, FormControl, FormGroup } from 'react-bootstrap';
class Item extends Component{

    render(){
        let item=this.props.item;
        return(
            <FormGroup controlId={"item_"+item.id}>
                <Col sm={4}>
                    {item.name}
                </Col>
                <Col sm={2}>
                    <FormControl type="number" name={item.name} />
                </Col>
            </FormGroup>
        );
    }
}

export default Item;