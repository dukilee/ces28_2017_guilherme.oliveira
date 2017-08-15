import java.util.ArrayList;

class MoneyBag implements MoneyInterface {

	public MoneyBag() {
		bag = new ArrayList<Money>();
	}

	public int size() {
		return bag.size();

	}

	// returns obj i from money bag
	public Money getobj(int i) {
		return this.getMoneylist().get(i);

	}

	public void setmoney(Money money) {
		// procura currency
		int i;
		boolean new_currency = true;
		for (i = 0; i < this.size(); ++i) {
			if (this.getobj(i).getCurrency().equals(money.getCurrency())) {
				new_currency = false;
				this.getobj(i).setAmount(this.getMoneylist().get(i).getAmount() + money.getAmount());
			}
		}
		if (new_currency) {
			this.getMoneylist().add(money);
		}

	}

	public ArrayList<Money> getMoneylist() {
		return bag;

	}

	public void printmonies() {
		int i;
		if (this.size() == 0) {
			System.out.println("N�o h� elementos em MoneyBag");
		} else {
			for (i = 0; i < this.size(); ++i) {
				System.out.println(this.getobj(i).getCurrency().getValue() + ":" + this.getobj(i).getAmount());
			}
		}

	}
	
	
	int getTotalAmount(){
		int total = 0;
		for (int i=0; i<this.size();++i){
			total=total+(this.getobj(i).getAmount())*(this.getobj(i).getCurrency().getConv());
			
		}
		return total;
		
		
	}

	ArrayList<Money> bag;
}
