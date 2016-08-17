import javax.swing.*;
import java.awt.*;

public class MenuPanel
{
    // instance variables - replace the example below with your own
    private JPanel menu;


    /**
     * Constructor for objects of class HeaderMenu
     */
 

    public MenuPanel(PanelManager pm, DataManager dm)
    {
       menu = new JPanel(new FlowLayout(FlowLayout.LEFT,0,10));
       menu.setBackground(new Color(0,0, 150));
       menu.setBounds(0, 100, 800, 50 );
        
       JButton computer = createMenuButton("[ Computers/Electronics ]", false);
       computer.addActionListener(new MenuButtonListener(pm, dm));
       menu.add(computer);
        
       JButton supplies = createMenuButton("[ Lab Supplies ]", false) ;
       supplies.addActionListener(new MenuButtonListener(pm, dm));
       menu.add(supplies);
       
       JButton equip = createMenuButton("[ Personnel Equipment ]", false);
       equip.addActionListener(new MenuButtonListener(pm, dm));
       menu.add(equip);
       
       JButton tools = createMenuButton("[ Tools ]", false);
       tools.addActionListener(new MenuButtonListener(pm, dm));
       menu.add(tools);
       
       JButton vehicle = createMenuButton("[ Vehicle Equipment ]", false);
       vehicle.addActionListener(new MenuButtonListener(pm, dm));
       menu.add(vehicle);
       
       JPanel search = new JPanel();
       search.setBackground(new Color(0, 0, 150));

       search.add(new JTextField(15));
       
       menu.add(search);
       menu.add(createMenuButton("Search", true));
    }

    public JPanel getButton()
    {      
       return this.menu;
    }
    private  JButton createMenuButton(String text, boolean normalButton) {
        JButton button = new JButton(text);
    
       button.setForeground(Color.BLACK);
       button.setMargin(new Insets(0,5,0,5));
       button.setActionCommand(text);
       
       if(!normalButton){
        button.setMargin(new Insets(0,0,0,0));
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false); 
       }

        if(!normalButton){
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(150, 150, 150));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(255, 255, 255));
            }
        });
        }
        return button;
    }
    

    
    public JPanel getPanel()
    {      
       return this.menu;
    }
}
