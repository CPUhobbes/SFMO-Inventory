import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
 
public class GraphicInterface {
    
    private JFrame frame;
    
    
    public  void addComponentsToPane(Container pane) {
        pane.setLayout(null);
 
        //Setup 3 main panels
        DataManager dataManager = new DataManager();
        
        PanelManager panelManager = new PanelManager(dataManager);
        
        //Add main panels to frame
        pane.add(panelManager.getHeaderPanel());
        pane.add(panelManager.getMenuPanel());
        pane.add(panelManager.getBodyPanel());
     
        
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("SFMO Inventory Supplies Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
        
        //Size and display the window.
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    

    
}