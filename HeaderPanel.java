import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class HeaderPanel
{
    // instance variables - replace the example below with your own
    private JPanel header;
    private DataManager dataManager;
    private PanelManager panelManager;


    /**
     * Constructor for objects of class HeaderMenu
     */
    public HeaderPanel(PanelManager panelManager, DataManager dataManager)
    {
       header = new JPanel(new GridBagLayout());
       updateHeader(header, dataManager, panelManager);
    }

    public static JLabel imageResizer(String name, int x, int y){
        Image img = new ImageIcon(name).getImage();
        Image newimg = img.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        JLabel imageLabel = new JLabel(newIcon);
       
        return imageLabel;
    }
    
    public JPanel getPanel()
    {      
        return this.header;
    }
    
    public void updateHeader(JPanel header, DataManager dataManager, PanelManager panelManager){
        //this.dataManager = dataManager;
        this.header = header;
        this.dataManager = dataManager;
        header.setBackground(new Color(255, 255, 255));
        header.setBounds(0, 0,   800, 100);
       
        GridBagConstraints c = new GridBagConstraints();
        c.weightx=1;
        c.weighty=1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx=0;
        c.gridy=0;
        c.fill= GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,-15,0,0);
        c.anchor=GridBagConstraints.NORTHWEST;
        header.add(imageResizer("img/sfmowebseal.jpg", 90, 90), c);
        
        JLabel title = new JLabel ("SFMO Inventory Supplies Form");
        title.setFont(title.getFont().deriveFont(36.0f));
        title.setForeground(new Color(0,0, 150));
        c.gridx=1;
        c.gridy=0;
        c.insets = new Insets(25,50,0,0);
        header.add(title, c);

        
        JButton cart = new JButton("Cart [ "+dataManager.getCartNumber()+" ]");
        cart.setName("cart");
       // JLabel cart =  new JLabel ("Cart [ "+dataManager.getCartNumber()+" ]");//get cart amount from DataManager
        cart.addActionListener(new MenuButtonListener(panelManager, dataManager));  
        cart.setForeground(new Color(200,0, 0));
        cart.setFont(title.getFont().deriveFont(16.0f));
        cart.setOpaque(false);
        cart.setContentAreaFilled(false);
        cart.setBorderPainted(false);
        cart.setFocusPainted(false);
        c.gridx=2;
        c.gridy=0;
        c.insets = new Insets(10,10,0,0);
        header.add(cart, c);
        
        //checkout button
        try {
            BufferedImage buttonIcon = ImageIO.read(new File("img/checkout1.png"));
            JButton checkout = new JButton(new ImageIcon(buttonIcon));
            checkout.addActionListener(new MenuButtonListener(panelManager, dataManager)); 
            checkout.setName("cart");
            checkout.setForeground(new Color(0,200, 0));
            checkout.setFont(title.getFont().deriveFont(16.0f));
            checkout.setOpaque(false);
            checkout.setContentAreaFilled(false);
            checkout.setBorderPainted(false);
            checkout.setFocusPainted(false);
            c.gridx=2;
            c.gridy=0;
            c.insets = new Insets(30,10,0,0);
            header.add(checkout, c);
        }  catch (IOException ex) {
            }
    }
    public void refreshHeader(){
        header.removeAll();
        header.revalidate();
        updateHeader(header,dataManager, panelManager); 
        header.repaint();
    }
}
