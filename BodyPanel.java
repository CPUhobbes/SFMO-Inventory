import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class BodyPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BodyPanel
{
    // instance variables - replace the example below with your own
    private JPanel body;

    /**
     * Constructor for objects of class HeaderMenu
     */
    public BodyPanel(PanelManager panelManager, DataManager dataManager)
    {
       body = new JPanel();
       defaultBody(body, panelManager, dataManager);

       
    }

    
    public JPanel getPanel()
    {      
       return this.body;
    }
    
    public void defaultBody(JPanel body, PanelManager panelManager, DataManager dataManager){
        this.body = body;
        
        body.setLayout(new GridBagLayout());

        body.setBackground(new Color(255,255, 255));
        body.setBounds(0, 150, 800, 650 );
        JPanel outerBox = new JPanel(new GridLayout(1,1));
        
        JPanel buttonBox = new JPanel(new GridLayout(2,3,30,30));
        buttonBox.setBackground(new Color(255, 255, 255));
        //Computer button
        JButton computerButton = new JButton("<html>Computers and<br />&nbsp;&nbsp;&nbsp;&nbsp;Electronics</html>");
        computerButton.setFont(computerButton.getFont().deriveFont(18.0f));
        computerButton.setPreferredSize(new Dimension(200, 80));
        computerButton.addActionListener(new MenuButtonListener(panelManager, dataManager));
        buttonBox.add(computerButton);
        
        //personel equip button
        JButton personButton = new JButton("<html>&nbsp;&nbsp;Personnel<br />Equipment</html>");
        personButton.setPreferredSize(new Dimension(200, 80));
        personButton.setFont(computerButton.getFont().deriveFont(18.0f));
        personButton.addActionListener(new MenuButtonListener(panelManager, dataManager));
        buttonBox.add(personButton);
        
        //tool button
        JButton toolButton = new JButton("Tools");
        toolButton.setPreferredSize(new Dimension(200, 80));
        toolButton.setFont(computerButton.getFont().deriveFont(18.0f));
        buttonBox.add(toolButton);

        //lab supplies button
        JButton labButton = new JButton("<html>Arson Lab <br />&nbsp;Supplies</html>");
        labButton.setPreferredSize(new Dimension(200, 80));
        labButton.setFont(computerButton.getFont().deriveFont(18.0f));
        buttonBox.add(labButton);
        
        //vehicle equip button
        JButton vehicleButton = new JButton("Vehicle Equipment");
        vehicleButton.setPreferredSize(new Dimension(200, 80));
        vehicleButton.setFont(computerButton.getFont().deriveFont(18.0f));
        buttonBox.add(vehicleButton);
        
        //Admin button
        JButton adminButton = new JButton("Administrator");
        adminButton.setPreferredSize(new Dimension(200, 80));
        adminButton.setFont(computerButton.getFont().deriveFont(18.0f));
        buttonBox.add(adminButton);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(-100,0,0,0);
        outerBox.add(buttonBox);
        body.add(outerBox,c);
    }
}
