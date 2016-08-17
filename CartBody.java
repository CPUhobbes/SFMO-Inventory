import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CartBody
{
    // instance variables - replace the example below with your own
    private JPanel body;
    private JPanel header;

    //JPanels for each part of page
    private JPanel rowPanel; //item, textbox, button
    private JPanel columnPanel;  // column of row containers
    private JPanel pagePanel; //holds both columns
    
    //Constraints for each JPanel 
    private GridBagConstraints rowPC;
    private GridBagConstraints columnPC;
    private GridBagConstraints pagePC;
    
    
    
    private JPanel itemContainer;    
    private JPanel menuContainer; 
    private JLabel tempLabel;
    private JButton tempButton;
    private JTextField tempItemField;
    private JPanel topPanel;
    private JPanel tPane;
    private JTabbedPane tabbedPane;
    private JPanel[] panelArray;
    
    private GridBagConstraints menuContainerConstraints;
    private GridBagConstraints itemContainerConstraints;

    public CartBody(PanelManager panelManager, DataManager dataManager){

        GridBagConstraints c = new GridBagConstraints();
        
        //Get panels and set bounds
        body = panelManager.getBodyPanel();
        header = panelManager.getHeaderPanel();
        body.setLayout(new GridBagLayout());
        body.setBounds(0, 150, 800, 650 );
        
        //Create header for body panel
        JPanel titlePanel = new JPanel();
        c.anchor = GridBagConstraints.NORTHWEST;
        JLabel textLabel = new JLabel("Cart Body");
        textLabel.setFont(textLabel.getFont().deriveFont(24.0f));
        textLabel.setForeground(new Color(0,0, 150));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.setBackground(new Color(255, 255, 255));
        titlePanel.add(textLabel);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy =0;
        c.weightx=1;
        c.weighty=1;
        c.gridwidth = 1;
        c.gridheight = 2;
        body.add(titlePanel, c);
        
        
        //Get entire list of possible items for cart
        String[] computerList = dataManager.getComputerCartItems();
        Arrays.sort(computerList);
        
        //Initialize starting positions for pages based on number of items
        int xCoord=0;
        int yCoord=1;
        
        //Max number of items on page
        int maxSize = 13;
        
        //Calculate number of pages needed and initialize array of pages
        int numPages = (int)Math.ceil((double)computerList.length/26.0);
        String[][] pageComputerList = new String[numPages][26];
        for(int i = 0; i <numPages; ++i){ 
            for(int j = 0;j<26;++j){
                if( j+(26*(i)) < computerList.length){
                    pageComputerList[i][j]=computerList[j+26*(i)];
                }
            }
        }

        //Initialize JPanel Page array based on number of pages
        panelArray= new JPanel[numPages];
        for(int panelLoop=0; panelLoop<numPages; ++panelLoop){  //NEW LOOP FOR MULTIPLE PANELS
        
           //Top body panel to hold daughter panels (menucontainer, itemcontainer)
            topPanel = new JPanel(new GridBagLayout());
            topPanel.setPreferredSize(new Dimension(790, 552)); //Set dimensions to fill out tab
            
            //Cart Menu
            menuContainer = new JPanel(new GridBagLayout());  
            menuContainerConstraints = new GridBagConstraints();
            menuContainerConstraints.anchor=GridBagConstraints.WEST;
            menuContainerConstraints.insets = new Insets(10,10,0,0);
            menuContainer.setBackground(new Color(255, 255, 255));
            
            //add to "page" panel
            itemContainerConstraints = new GridBagConstraints();
            itemContainerConstraints.insets = new Insets(5,10,10,5);
            itemContainerConstraints.anchor=GridBagConstraints.WEST;
    
            //Setup field for logic to allow alternating background for list
            boolean listbg = false;
           
            //Display 1st header of cart list
            createCartHeader(0);
            int num=1;
            //Generate entire cart list and display it
            //for(int i = 0; i <pageComputerList[k].length;++i){
            for(int i = 0; i <pageComputerList[panelLoop].length;++i){
                if(pageComputerList[panelLoop][i]!=null){
               
                    //Create fields for cart
                    tempLabel = new JLabel(pageComputerList[panelLoop][i]); 
                    tempItemField = new JTextField(3); 
                    tempButton = new JButton("Add to Cart");
                
                    //create field container to hold 3 fields
                    itemContainer = new JPanel(new GridBagLayout());
                    itemContainerConstraints.insets = new Insets(5,20,5,0);
                    //1st field
                    itemContainerConstraints.anchor=GridBagConstraints.LINE_START;
                    itemContainerConstraints.gridx=0;
                    itemContainerConstraints.weightx = 1;
                    tempLabel.setFont(tempLabel.getFont().deriveFont(14.0f));
                    itemContainer.add(tempLabel,itemContainerConstraints);
                    //2nd field
                    itemContainerConstraints.gridx=1;
                    itemContainerConstraints.weightx = 1;
                    itemContainerConstraints.anchor=GridBagConstraints.LINE_END;
                    itemContainer.add(tempItemField,itemContainerConstraints);
                    itemContainerConstraints.weightx = 0;
                    //3rd field
                    itemContainerConstraints.gridx=2;
                    //add actionListener for button
                    tempButton.addActionListener(new CartButtonListener(panelManager, dataManager, computerList[i], tempItemField)); 
                    itemContainer.add(tempButton,itemContainerConstraints);
                
                    //Swap background color based on display list order
                    if(listbg == false){
                        itemContainer.setBackground(new Color(255, 255, 255));
                        listbg = true;
                    }
                    else
                        listbg = false;
                        
                   //Add to secondary panel to hold itemcontainer panels
                    menuContainerConstraints.fill = GridBagConstraints.HORIZONTAL;
                    menuContainerConstraints.gridx=xCoord;
                    menuContainerConstraints.gridy=yCoord;
                    menuContainerConstraints.insets = new Insets(0,20,0,0);
                    menuContainer.add(itemContainer,menuContainerConstraints);
                    
                    //Move the position of the itemcontainer to evenly divide columns
                    //pageComputerList[panelLoop][13]!= null because of the array allows for 26 items by default
                    if(yCoord >=maxSize && pageComputerList[panelLoop].length>13 && pageComputerList[panelLoop][13]!=null){
                        createCartHeader(1);
                        yCoord=1;
                        xCoord+=1;
                        listbg = false;
                    }
                    else
                        yCoord+=1;
                }
            }
                                
            //Adjust position of topPanel
            GridBagConstraints topPanelConstraints = new GridBagConstraints();
            topPanelConstraints.anchor=GridBagConstraints.NORTHWEST;
            topPanelConstraints.weightx=1;
            topPanelConstraints.weighty=1;
            topPanelConstraints.insets = new Insets(10,10,0,0);
            topPanel.setBackground(new Color(255, 255, 255));
            topPanel.add(menuContainer, topPanelConstraints);
            
            
            
            
            
            
            //tabbedPane.add(pageOne,0 );
            
            panelArray[panelLoop] = topPanel;
            xCoord=0;
            yCoord=1;
            
        }//END OF LOOP FOR MULTIPLE PANELS
        //add completed panel to tabbed page
        tPane= new JPanel(new GridBagLayout());
        tabbedPane = new JTabbedPane();
        for(int i=0;i<panelArray.length;++i){
            tabbedPane.addTab( "Page "+(i+1), panelArray[i]); //////ADDED PANELS TO ARRAY OF JPANELS

        }
        
        tPane.setBackground(new Color(255, 255, 255));
    
        GridBagConstraints d = new GridBagConstraints();//Insets for tabbed pane to fill out
        d.insets = new Insets(0,-6,0,0);
        tPane.add(tabbedPane, d);
        
        c.insets = new Insets(42,0,0,0);
        c.gridx=0;
        c.gridy =1;
        
        body.add(tPane, c);
        
    
    
        //UPDATE HEADER CART NUMBER!!!!!!!!!!
        panelManager.updateHeaderPanel();
       
       
       


    }
    public JPanel getBody(){
        return body;
    }
    
    public void createCartHeader(int xPos){

        itemContainer = new JPanel(new GridBagLayout());

        itemContainerConstraints.anchor=GridBagConstraints.LINE_START;
        itemContainerConstraints.gridx=0;
        itemContainerConstraints.weightx = 1;
        JLabel tempHeaderLabel = new JLabel("Item");
        tempHeaderLabel.setFont(tempHeaderLabel.getFont().deriveFont(18.0f));
        tempHeaderLabel.setForeground(new Color(200,0, 0));
        itemContainer.add(tempHeaderLabel,itemContainerConstraints);
            
        tempHeaderLabel = new JLabel("Quantity");
        itemContainerConstraints.gridx=1;
        itemContainerConstraints.weightx = 0;
        itemContainerConstraints.anchor=GridBagConstraints.LINE_START;
        tempHeaderLabel.setFont(tempHeaderLabel.getFont().deriveFont(18.0f));
        tempHeaderLabel.setForeground(new Color(200,0, 0));
        itemContainer.add(tempHeaderLabel,itemContainerConstraints);
            
        itemContainerConstraints.anchor=GridBagConstraints.LINE_END;
        itemContainerConstraints.gridx=2;
        itemContainer.add(new JLabel("                          "),itemContainerConstraints);

        menuContainerConstraints.fill = GridBagConstraints.HORIZONTAL;

        menuContainerConstraints.gridx=xPos;
        menuContainerConstraints.gridy=0;
        menuContainerConstraints.insets = new Insets(0,20,0,0);
        menuContainer.add(itemContainer,menuContainerConstraints);
        
        
        
        
    }
}
