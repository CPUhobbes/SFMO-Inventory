import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
/**
 * Write a description of class ButtonListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuButtonListener implements ActionListener
{
    // instance variables - replace the example below with your own
    private DataManager dataManager;
    private PanelManager panelManager;

    /**
     * Constructor for objects of class ButtonListener
     */
    public MenuButtonListener(PanelManager panelManager, DataManager dataManager){
        //body = pm.getBodyPanel();
        //header = pm.getHeaderPanel();
        this.dataManager = dataManager;
        this.panelManager = panelManager;

    }
       
    public void actionPerformed(ActionEvent e) {
            JPanel body = panelManager.getBodyPanel();
            JPanel header = panelManager.getHeaderPanel();
            body.removeAll();
            header.removeAll();

            String command = e.getActionCommand();
            
            JButton o = (JButton)e.getSource();
            String name = o.getName();
            
            if(command.equals("[ Computers/Electronics ]") || command.equals("<html>Computers and<br />&nbsp;&nbsp;&nbsp;&nbsp;Electronics</html>"))
                new ComputerBody(panelManager, dataManager, "compElec");
            
            //get action from cart click, used getName since ActionCommand will change values     
            /*
             * TEMP PANEL JUST FOR TESTING 
             */   
            /*else if(name.equals("cart")){
               new ComputerBody(panelManager, dataManager, "Cart");
            }*/
            
            else if(command.equals("[ Personnel Equipment ]") || command.equals("<html>&nbsp;&nbsp;Personnel<br />Equipment</html>"))
                new ComputerBody(panelManager, dataManager, "personnel"); 
            /*else if(command.equals("[ Tools ]") || command.equals("Tools"))
                new ToolsBody(panelManager, dataManager);
            else if(command.equals("[ Lab Supplies ]") || command.equals("<html>Arson Lab <br />&nbsp;Supplies</html>"))
                new LabBody(panelManager, dataManager);
            else if(command.equals("[ Vehicle Equipment ]") || command.equals("Vehicle Equipment"))
                new VehicleBody(panelManager, dataManager);
            else if(command.equals("Administrator"))
                new AdminBody(panelManager, dataManager);
            else
                new DefaultBody();   
            
            if(command.equals("Checkout") || command.equals("<html>Checkout</html>"))
                new ComputerBody(panelManager, dataManager);*/
            body.revalidate();
            body.repaint();
            header.revalidate();
            header.repaint();
    }
}
