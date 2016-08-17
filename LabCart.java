import java.util.*;

public class LabCart
{ 
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> cartItems;
    
    public LabCart()
    { 
        cartItems = new HashMap<String, Integer>();
        cartItems.put("1 Gallon Can",0);
        cartItems.put("1 Quart Can",0);
        cartItems.put("4 Can Box",0);
        cartItems.put("2 Can Box",0);
        cartItems.put("1 Can Box",0);
        cartItems.put("Evidence Tape",0);
        cartItems.put("Large Evidence Bag",0);
        cartItems.put("Medium Evidence Bag",0);
        cartItems.put("Gauze Pads",0);
        cartItems.put("Biological Bag",0);
        
    }

    public HashMap getLabCart(){
        return cartItems;
    }
    
    public String[] labCartListString(){
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
