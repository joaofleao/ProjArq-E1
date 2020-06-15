package Controller;

public class DebitCardStrategy implements PaymentStrategy {

	private String name;
	private String number;
	private String cvv;
	private String date;
	
	public DebitCardStrategy(String name, String number, String cvv, String date){
		this.name = name;
		this.number = number;
		this.cvv = cvv;
		this.date = date;
	}
	
    @Override
    public void pay(double price) {
        System.out.println("Pago usando Cartão de Débito\nValor Total: " + price);
    }

}