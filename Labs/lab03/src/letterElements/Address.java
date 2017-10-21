package letterElements;

public class Address {
	public Address(String value){
		this.value = value;
	}
	
	public Address(Address address){
		this.value = address.getValue();
	}
	
	public String getValue(){
		return value;
	}
	
	public Address clone(){
		return new Address(this);
	}
	
	private String value;
}
