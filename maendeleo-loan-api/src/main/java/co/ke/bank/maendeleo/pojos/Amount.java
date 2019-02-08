package co.ke.bank.maendeleo.pojos;

import co.ke.bank.maendeleo.enums.Currency;

public class Amount {

	private String currency;
	private int amount;
	public Amount() {
		super();
	}
	public Currency getCurrency() {
		if(this.currency.equals("KES"))
			return Currency.KES;
		if(this.currency.equals("RWF"))
			return Currency.RWF;
		if(this.currency.equals("TZS"))
			return Currency.TZS;
		if(this.currency.equals("UGX"))
			return Currency.UGX;
		if(this.currency.equals("USD"))
			return Currency.USD;
		return Currency.GBP;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
