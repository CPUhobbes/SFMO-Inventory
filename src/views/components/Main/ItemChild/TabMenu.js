import React, { Component } from 'react';
import { Row, Tabs, Tab, Grid} from 'react-bootstrap';

//Children Components
import InventoryItem from './InventoryItem';


class TabMenu extends Component{

    render(){
        const items=this.props.items;
        const itemsChunck = Math.ceil(items.length/10)
		let splitArr = [];

        //Split into 10 piece chuncks
		for(let i=0;i<itemsChunck-1;++i){
			splitArr.push(items.slice(i*10,(i+1)*10));
		}

		//Push remainder
		splitArr.push(items.slice(10*(itemsChunck-1)));
		//console.log(splitArr);

        if(items<1){
            return (
                <h2> No Items Found </h2>

            )
        }
        else{

            return(
                <div>
                    <Tabs defaultActiveKey={1} id={"tab_menu"+this.props.menuName}>
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
        
    }    
}

export default TabMenu;