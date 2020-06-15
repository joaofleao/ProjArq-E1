package Controller;

public class PayPalStrategy implements PaymentStrategy {

	private String email;
	private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
		this.password = password;
    }

	@Override
    public void pay(double price) {
        System.out.println("Pago usando PayPal\nValor Total: " + price);

    }

}