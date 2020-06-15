package model;

public abstract class Card {
	
    private String name;
	private String number;
	private String cvv;
	private String date;
	
	public Card(String name, String number, String cvv, String date){
		this.name = name;
		this.number = number;
		this.cvv = cvv;
        this.date = date;
    }

    public void validate() {
        //method to validate card
    }
    
}
