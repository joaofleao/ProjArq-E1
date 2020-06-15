package Model;
import java.util.*;
import Model.Item;

public class Cart implements Observer{	
	
    private ArrayList<Item> cart;	

	public Cart(){
        cart = new ArrayList<Item>();
    }

	public void addItem(Item i) {
        cart.add(i);
    } 
    public Item getFromCart(int i) {
        Item item =  cart.get(i);
        cart.remove(i);
        return item;
    }

    public ArrayList<Item> getCarrinho() {
        return cart;
    }

    @Override
    public void update(Observable o, Object arg) {
        Product p = (Product) o;
        System.out.println(ANSI_RED + ((Product) o).getName() + " adicionado ao carrinho utilizando o padrão Observer." + ANSI_RESET);
    }
    
}