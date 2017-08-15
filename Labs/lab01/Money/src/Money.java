
class Money implements MoneyInterface {
	// construtor item 1, usando os setters
	public Money() {
		
	}

	public int getAmount() {
		return _amount;
	}

	// item 1 set amount
	public void setAmount(int amount) {

		this._amount = amount;
	}

	public Currency getCurrency() {
		return _currency;
	}

	// item 1 set currency
	public void setCurrency(Currency currency) {
		this._currency = currency;
	}

	public boolean equals(Object o) {

		// Check pointer
		if (o == this) {
			return true;
		}

		/* Check instance or Null pointer */
		if (!(o instanceof Money)) {
			return false;
		}

		// typecast o to Money so that we can compare data members
		Money c = (Money) o;

		// Compare the data members and return accordingly
		return this.getCurrency().equals(c.getCurrency()) && this.getAmount() == c.getAmount();
	}

	public Object add(Money m) {
		if (this.getCurrency().equals(m.getCurrency())) {
			this.setAmount(this.getAmount() + m.getAmount());
			Money aux = this;
			return aux;
		}
		MoneyBag Bagaux = new MoneyBag();
		Bagaux.setmoney(this);
		Bagaux.setmoney(m);
		return Bagaux;

	}

	private int _amount;
	private Currency _currency;

}
