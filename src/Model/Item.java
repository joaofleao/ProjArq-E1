package Model;

public class Item {
    private String name;
    private String brand;
    private double price;
    public Item(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "[" + name + " " + brand + " por apenas R$" + price + "]";
    }


    
}