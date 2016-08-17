import java.util.*;

public class PersonnelCart
{ 
    // instance variables - replace the example below with your own
    private HashMap<String, Integer> cartItems;
    
    public PersonnelCart()
    { 
        cartItems = new HashMap<String, Integer>();
        cartItems.put("ASP Baton",0);
        cartItems.put("Badge",0);
        cartItems.put("Badge Wallet",0);
        cartItems.put("Ballistic Vest",0);
        cartItems.put("BDU Pant",0);
        cartItems.put("BDU Pant (Tan)",0);
        cartItems.put("Binoculars",0);
        cartItems.put("Boots",0);
        cartItems.put("Ball Cap",0);
        cartItems.put("Flashlight (large)",0);
        cartItems.put("Flashlight (Small)",0);
        cartItems.put("Handcuffs",0);
        cartItems.put("Helmet",0);
        cartItems.put("Jacket",0);
        cartItems.put("Knee Pads",0);
        cartItems.put("OC Spray",0);
        cartItems.put("Police ID",0);
        cartItems.put("Respirator",0);
        cartItems.put("Safety Vest",0);
        cartItems.put("Shirts (LS)",0);
        cartItems.put("Shirts (SS)",0);
        cartItems.put("Travel Card",0);
        cartItems.put("Tyvex Suit",0);
    }

    public HashMap getPersonnelCart(){
        return cartItems;
    }
    
    public String[] personnelCartListString(){
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
