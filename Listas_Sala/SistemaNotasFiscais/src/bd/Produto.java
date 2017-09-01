package bd;

public class Produto implements Item{
	String nome;
	int quant;
	double preco;

	public Produto(String n, int q, double p){
		preco = p;
		quant = q;
		nome = n;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getQuant(){
		return quant;
	}
	
	public double getPreco(){
		return preco;
	}
}
