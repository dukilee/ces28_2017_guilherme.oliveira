package bd;

public class ItemDeVenda {
	private Item item;
	public ItemDeVenda(Item i){
		item = i;
	}
	public Item getItem(){
		return item;
	}
	
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!ItemDeVenda.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final ItemDeVenda other = (ItemDeVenda) obj;
	    if ((item.getNome() == null) ? (other.getItem().getNome() != null) 
	    		: !item.getNome().equals(other.getItem().getNome())) {
	        return false;
	    }
	    return item.getPreco() == other.getItem().getPreco() &&
	    		item.getQuant() == other.getItem().getQuant();
	}
	
	
}
