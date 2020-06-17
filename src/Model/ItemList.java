package model;
import java.util.*;
import java.util.Observer;

public class ItemList implements Observer {	
	
    private ArrayList<Item> list;
    private String name;

	public ItemList(String name){
        list = new ArrayList<Item>();
        this.name = name;
    }

	public void addItem(Item i) {
        list.add(i);
      
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

    public String getName() {
        return name;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update em " + name);        
    }
 
}