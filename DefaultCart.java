import java.util.*;

public class DefaultCart
{ 
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> cartItems;
    
    public DefaultCart()
    { 
        cartItems = new HashMap<String, Integer>();
        cartItems.put("",0);
    }

    public HashMap getPersonnelCart(){
        return cartItems;
    }
    
    public String[] defaultCartListString(){
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
