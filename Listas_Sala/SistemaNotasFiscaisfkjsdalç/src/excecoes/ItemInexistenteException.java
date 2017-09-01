package excecoes;

public class ItemInexistenteException extends RuntimeException{
    private static final long serialVersionUID = 5162711184359818592L;
	public ItemInexistenteException(){
		super();
	}
	public ItemInexistenteException(String s){
		super(s);
	}
}