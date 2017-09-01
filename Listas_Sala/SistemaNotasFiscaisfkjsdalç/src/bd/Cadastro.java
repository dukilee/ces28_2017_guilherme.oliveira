package bd;

import java.util.ArrayList;

import sistema.VerificadorCPF;

public class Cadastro {
	private ArrayList<Cliente> lista;
	VerificadorCPF verificador;
	BDCliente bd;
	
	public Cadastro(VerificadorCPF v, BDCliente b){
		bd = b;
		verificador = v;
		lista = new ArrayList<Cliente>();
	}
	
	public void cadastrar(Cliente c){
		if(verificador.verifica(c.getCpf()))
			lista.add(c);
	}
	
	public Boolean cadastrado(Cliente c){
		return lista.contains(c);
	}	
}
