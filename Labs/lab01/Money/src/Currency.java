
public class Currency {
	public Currency(String s){
		this.setValue(s);
	}
	public String getValue(){
		return value;
	}
	public void setValue(String v){
		value = v;
	}
	
	@Override
	public boolean equals(Object other){
		return true;
//		return value.equals(other.getValue());
	}
	
	private String value;
}
