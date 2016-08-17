import java.util.*;
/**
 * Write a description of class DataManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataManager
{
    // instance variables - replace the example below with your own
    private int cartNum;
    private ComputerCart computerCart;
    private PersonnelCart personnelCart;
    private HashMap<String, Integer> cartItems;

    /**
     * Constructor for objects of class DataManager
     */
    public DataManager(){
       cartNum=0;
       cartItems = new HashMap<String, Integer>(1);
       //Initialze each type of cart
       computerCart = new ComputerCart();
       personnelCart = new PersonnelCart();
       
    }

    
    public int getCartNumber(){
        return cartNum;
    }
    
    public void changeCartNum(int items){
        cartNum+=items;
    }
    
    public void updateComputerCart(String item, int itemsAdded){
        computerCart.updateCart(item, itemsAdded);
    }
    public void addItem(String item, int itemsAdded){
        if(cartItems.containsKey(item)){
            item = item+cartItems.get(item);
        }
        cartItems.put(item, itemsAdded);
    }
    public String[] getCartItems(String cartName){
        String[] cartString = {};
        if(cartName.equals("compElec"))
            cartString = computerCart.computerCartListString();
        if(cartName.equals("personnel"))
            cartString = personnelCart.personnelCartListString();
        
            return cartString;
    }
    
    public HashMap<String, Integer> getCheckoutCartItems(){
        return this.cartItems;
    }
}
