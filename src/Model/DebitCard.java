package model;
public class DebitCard extends Card {
    public DebitCard(String name, String number, String cvv, String date) {
        super(name, number, cvv, date);
    }
    @Override
    public void validate() {
        // TODO Auto-generated method stub
        System.out.println("Compra aprovada no Cartão de Débito"); 
    }
}