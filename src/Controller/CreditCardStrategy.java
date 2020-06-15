package Controller;

public class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String number;
	private String cvv;
	private String date;
	
	public CreditCardStrategy(String name, String number, String cvv, String date){
		this.name = name;
		this.number = number;
		this.cvv = cvv;
		this.date = date;
	}
	
    @Override
    public void pay(double price) {
        System.out.println("Pago usando Cartão de Crédito\nValor Total: " + price);
    }

}