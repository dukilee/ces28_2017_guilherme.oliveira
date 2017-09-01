package excecoes;

public class ItemInexistenteException extends Exception{
	public ItemInexistenteException(){
		super();
	}
	public ItemInexistenteException(String message){
		super(message);
	}
}
