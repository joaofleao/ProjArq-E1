package controller;
import model.PaymentStrategy;
import java.util.Random;

public class BillOfExchangeStrategy implements PaymentStrategy {
    
    private String billNumber = generateNumber();
	public BillOfExchangeStrategy(){


    }
    private String generateNumber() {
        Random rand = new Random();
        String number = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 6; k++) {
                    int alg  = rand.nextInt(10);
                    number = number + alg;
                    
                }
                if(j==0) number = number + ".";
            }
            number = number + " ";
        }
        return number;
    }
	
    @Override
    public void pay(double price) {
        System.out.println("Boleto Gerado\nValor Total: " + price + "\nNúmero do Boleto: " + billNumber);

    }

}