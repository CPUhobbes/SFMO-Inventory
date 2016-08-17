import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class ButtonListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CartButtonListener implements ActionListener
{
    // instance variables - replace the example below with your own
    private DataManager dataManager;
    private PanelManager panelManager;
    private JButton button;
    private String item;
    private JTextField numItem;

    /**
     * Constructor for objects of class ButtonListener
     */
    public CartButtonListener(PanelManager panelManager, DataManager dataManager, String item, JTextField numItem){
        //body = pm.getBodyPanel();
        //header = pm.getHeaderPanel();
        this.dataManager = dataManager;
        this.panelManager = panelManager;
        //this.button = button;
        this.item = item;
        /*if(numItem.equals(""))
            this.numItem = 0;
        else    
            this.numItem = Integer.parseInt(numItem);*/
        this.numItem = numItem;

    }
       
    public void actionPerformed(ActionEvent e) {
        
        try {
            int cartNum = Integer.parseInt(numItem.getText());
            refreshHeader(cartNum);
            dataManager.addItem(item, cartNum);
        } catch (Exception d) {
            JOptionPane.showMessageDialog(null, "Please use a number when adding to the cart");
        }
            
    }
    
    private void refreshHeader(int cartNum){
        
           // System.out.println(item+" --- "+cartNum);
            dataManager.changeCartNum(cartNum);
            panelManager.updateHeaderPanel();
            panelManager.refreshHeaderPanel();
        }
}
