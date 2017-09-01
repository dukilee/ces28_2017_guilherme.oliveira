package bd;

public class Cliente {
	public Cliente(int CPF){
		cpf = CPF;
	}
	
	public int getCpf(){
		return cpf;
	}
	
	private int cpf;
}