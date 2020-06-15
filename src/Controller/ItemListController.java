package Controller;

import java.util.*;

import Model.Item;
import Model.ItemList;


public class ItemListController{	
	
    private ItemList list;	

	public ItemListController(boolean populated, String name){
        list = new ItemList(name);
        if (populated) populate();
    }

    public ItemList getItemListObject() {
        return list;
    }

    private void populate() {
        list.addItem(new Item("Celular", "Samsung", 2300.00));
        list.addItem(new Item("Computador", "Apple", 59999.00));
        list.addItem(new Item("Computador", "Asus", 4999.00));
        list.addItem(new Item("Laptop", "Lenovo", 2100.00));
        list.addItem(new Item("Fone de Ouvido", "HyperX", 250.00));
        list.addItem(new Item("Celular", "Apple", 5300.00));
        list.addItem(new Item("Monitor", "Acer", 500.00));
        
    }

    public Item remove(int index) {
        return list.getFromList(index);
    }
    public int size() {
        return list.getSize();
    }

    public void add(Item i) {
        list.addItem(i);        
    }

    public double price() {
        return list.getPrice();
    }

    public void pay(PaymentStrategy s) {
        s.pay(price());

    }

    @Override
    public String toString() {
        return list.toString();
    }

    
}