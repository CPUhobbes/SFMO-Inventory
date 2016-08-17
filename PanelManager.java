import javax.swing.*;
/**
 * Write a description of class PanelManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PanelManager
{
    // instance variables - replace the example below with your own
    private int cartNum;
    private DataManager dataManager;
    private HeaderPanel headerPanel;
    private MenuPanel menuPanel;
    private BodyPanel bodyPanel;

    /**
     * Constructor for objects of class PanelManager
     */
    public PanelManager(DataManager dataManager)
    {
        // initialise instance variables
        this.dataManager = dataManager;
        
        headerPanel = new HeaderPanel(this, dataManager);
        bodyPanel = new BodyPanel(this, dataManager);
        menuPanel = new MenuPanel(this, dataManager);
    }
    public JPanel getHeaderPanel(){
        return headerPanel.getPanel();
    }
    public JPanel getMenuPanel(){
        return menuPanel.getPanel();
    }
    public JPanel getBodyPanel(){
        return bodyPanel.getPanel();
    }
    public void updateHeaderPanel(){
        headerPanel.updateHeader(headerPanel.getPanel(), dataManager, this);
    }
    public void refreshHeaderPanel(){
         headerPanel.refreshHeader();
    }

}
