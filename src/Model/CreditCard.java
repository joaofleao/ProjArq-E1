package model;
public class CreditCard extends Card {
    public CreditCard(String name, String number, String cvv, String date) {
        super(name, number, cvv, date);
    }
    @Override
    public void validate() {
        System.out.println("Compra aprovada no Cartão de Crédito"); 
    }
}