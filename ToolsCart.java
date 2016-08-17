import java.util.*;

public class ToolsCart
{ 
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> cartItems;
    
    public ToolsCart()
    { 
        cartItems = new HashMap<String, Integer>();
        cartItems.put("25ft Tape Measure",0);
        cartItems.put("50ft Tape Measure",0);
        cartItems.put("100ft Tape Measure",0);
        cartItems.put("Crescent Wrench Set",0);
        cartItems.put("Action Packer",0);
        cartItems.put("Allen Wrench Set",0);
        cartItems.put("Axe",0);
        cartItems.put("Band Saw",0);
        cartItems.put("Bolt Cutters",0);
        cartItems.put("Bow Saw",0);
        cartItems.put("Brush (Small)",0);
        cartItems.put("Chisel Set",0);
        cartItems.put("Claw Hammer",0);
        
        cartItems.put("Concrete Drill Bit",0);
        cartItems.put("Crowbar (Small)",0);
        cartItems.put("Crowbar (Large)",0);
        cartItems.put("Power Tool Set",0);
        cartItems.put("Driver Set",0);
        cartItems.put("Evidence Tents",0);
        cartItems.put("Drill Bits",0);
        cartItems.put("Fencing Tool",0);
        cartItems.put("Fingerprint Kit",0);
        cartItems.put("Gerber Tool",0);
        cartItems.put("Hack Saw",0);
        cartItems.put("Hand Saw",0);
        cartItems.put("Hatchet",0);
        cartItems.put("HazMat Bag",0);
        cartItems.put("Hex Tool Set",0);
        cartItems.put("Ladder",0);
        
        cartItems.put("Leather Punch",0);
        cartItems.put("Lineman Pliers",0);
        cartItems.put("Metal Detector",0);
        cartItems.put("Nail Puller",0);
        cartItems.put("Pelican Case",0);
        cartItems.put("Pelican Light",0);
        cartItems.put("Pipe Wrench",0);
        cartItems.put("Pliers",0);
        cartItems.put("Push Broom",0);
        cartItems.put("Putty Knife",0);
        cartItems.put("Pruning Saw",0);
        cartItems.put("Pry Bar Set",0);
        cartItems.put("Rake",0);
        
        cartItems.put("Rake (Garden)",0);
        cartItems.put("Rolotape",0);
        cartItems.put("Rubber Mallet",0);
        cartItems.put("Sawsall Blades",0);
        cartItems.put("Screwdriver Set",0);
        cartItems.put("Scriber",0);
        cartItems.put("Shears",0);
        cartItems.put("Shovel (Garden)",0);
        cartItems.put("Shovel (Long)",0);
        cartItems.put("Shovel (Short)",0);
        cartItems.put("Sledge Hammer",0);
        cartItems.put("Socket Set",0);
        cartItems.put("Utility Knife",0);
        cartItems.put("Whisk Broom",0);
        cartItems.put("Wire Cutters",0);
        cartItems.put("Wood Rasp",0);
        cartItems.put("Work Lights",0);
        cartItems.put("Wrench Set",0);
    }

    public HashMap getToolsCart(){
        return cartItems;
    }
    
    public String[] toolsCartListString(){
        Set<String> keys = cartItems.keySet();
        String[] keyString = keys.toArray(new String[keys.size()]);
        return keyString;
        
    }
    public void updateCart(String item, int itemsAdded){
        cartItems.put(item,itemsAdded);
        for (String key : cartItems.keySet()) {
            System.out.println(key + " " + cartItems.get(key));
        }
    }
}
