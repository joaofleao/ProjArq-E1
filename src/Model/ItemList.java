package Model;
import java.util.*;
import java.util.Observable;

public class ItemList extends Observable {	
	
    private ArrayList<Item> list;

	public ItemList(){
        list = new ArrayList<Item>();
    }

	public void addItem(Item i) {
        list.add(i);
        setChanged();
        notifyObservers();
    } 

    public int getSize() {
        return list.size();
    }

    public Item getFromList(int i) {
        Item item =  list.get(i);
        list.remove(i);
        return item;
    }

    public ArrayList<Item> getList() {
        return list;
    }
    public double getPrice() {
        double sum = 0;
        for (Item item : list) {
            sum = sum + item.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        
        if(list.size()==0) return "Nenhum item";

        int index = 1;
        String text = "";

        for (Item item : list) {
            text = text + index + ": " + item  + "\n";
            index++;
        }
        return text;
    }
 
}