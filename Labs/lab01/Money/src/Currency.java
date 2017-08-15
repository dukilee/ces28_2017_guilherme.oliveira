
public class Currency {
	public Currency(String s, int conv){
		this.setValue(s);
		this.setConv(conv);
	}
	public String getValue(){
		return value;
	}
	public void setValue(String v){
		value = v;
	}
	
	public int getConv() {
		
		return conv;	
	}
	
	public void setConv(int conv) 
	{
		this.conv=conv;
	}
	
	
	
	@Override
	public boolean equals(Object o){
			 
	        // Check pointer
	        if (o == this) {
	            return true;
	        }
	 
	        /* Check instance or Null pointer*/
	        if (!(o instanceof Currency)) {
	            return false;
	        }
	         
	        // typecast o to Money so that we can compare data members 
	        Currency c = (Currency) o;
	         
	        // Compare the data members and return accordingly 
	        return this.getValue().equals(c.getValue()) && this.getConv()==c.getConv();
			
	}
	
	private String value;
	private int conv;//guarda a convercao da moeda 
}
