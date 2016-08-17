import java.util.*;

public class ComputerCart
{ 
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> cartItems;
    
    public ComputerCart()
    { 
        cartItems = new HashMap<String, Integer>();
        cartItems.put("Air Card",0);  
        cartItems.put("Camera",0);
        cartItems.put("Cell Phone",0);
        cartItems.put("Voice Recorder",0);
        cartItems.put("Flash",0);
        cartItems.put("Laptop",0);
        cartItems.put("Laptop Bag",0);
        cartItems.put("Laser",0);
        cartItems.put("SD Card",0);
        cartItems.put("Printer (portable)",0);
        cartItems.put("Printer (All-in-one)",0);
        cartItems.put("Programmer",0);
        cartItems.put("Tripod",0);
    }

    public HashMap getComputerCart(){
        return cartItems;
    }
    
    public String[] computerCartListString(){
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
