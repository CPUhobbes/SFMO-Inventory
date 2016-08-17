import java.util.*;

public class VehicleCart
{ 
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> cartItems;
    
    public VehicleCart()
    { 
        cartItems = new HashMap<String, Integer>();
        cartItems.put("Gas Card",0);
        cartItems.put("Inverter",0);
        cartItems.put("Radio",0);
        cartItems.put("Winch",0);
        
    }

    public HashMap getVehicleCart(){
        return cartItems;
    }
    
    public String[] vehicleCartListString(){
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
