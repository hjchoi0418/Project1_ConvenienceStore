package AnyPlace.model;

public class Cash {
	private String cash;
	private String deposit_withdrawal;
	private String amount;
	private String cash_date;
	
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public String getDeposit_withdrawal() {
		return deposit_withdrawal;
	}
	public void setDeposit_withdrawal(String deposit_withdrawal) {
		this.deposit_withdrawal = deposit_withdrawal;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCash_date() {
		return cash_date;
	}
	public void setCash_date(String cash_date) {
		this.cash_date = cash_date;
	}
		
	@Override
	public String toString() {
		return "Cash [cash=" + cash + ", deposit_withdrawal=" + deposit_withdrawal + ", amount=" + amount
				+ ", cash_date=" + cash_date + "]";
	}
}