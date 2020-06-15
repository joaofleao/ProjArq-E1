package controller;

import model.Card;
import model.CreditCard;
import model.DebitCard;
import model.PaymentStrategy;

public class CardStrategy implements PaymentStrategy {

	private String name;
	private String number;
	private String cvv;
	private String date;
	private boolean debit;
	private Card card;
	
	public CardStrategy(String name, String number, String cvv, String date, boolean debit){
		this.name = name;
		this.number = number;
		this.cvv = cvv;
		this.date = date;
		this.debit = debit;
		if (debit) card = new CreditCard(name, number, cvv, date);
		else card = new DebitCard(name, number, cvv, date);
	}
	
    @Override
    public void pay(double price) {
		card.validate();
    }

}