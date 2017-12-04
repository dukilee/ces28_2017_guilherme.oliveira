/*
 * Eclipse Platform
 * Version: 3.8.1
 * 
 * SistemasNotasFiscais
 * 
 * Feito por:
 * Gabriela Lima
 * Guilherme Silva
 */


package sistema;

import java.util.ArrayList;

import bd.BDProdutos;
import bd.Cliente;
import bd.Item;
import bd.ItemDeVenda;
import excecoes.SemItensException;

public class NotaFiscal {
	int valor;
	Cliente cliente;
	static int numero = 0;
	int meuId;
	int dataDeEntrega;
	ArrayList<ItemDeVenda> itens;
	BDProdutos bdProdutos;
	
	public NotaFiscal(Cliente c, int data, Item i, BDProdutos bd){
		meuId = ++numero;
		cliente = c;
		dataDeEntrega = data;
		bdProdutos = bd;
		itens = new ArrayList<ItemDeVenda>();
		addItem(i);
		}
	
	public void addItem(Item item){
		if(bdProdutos.contem(item)){
			ItemDeVenda novo = new ItemDeVenda(item);
			itens.add(novo);
		}
	}
	
	public void remItem(Item i) throws SemItensException{
		if(!contemItem(i)) return;
		ItemDeVenda velho = new ItemDeVenda(i);
		if(itens.size()==1){
			throw new SemItensException();
		}else{
			itens.remove(velho);
		}
	}
	
	public void trocaItem(Item itemNovo, Item itemAtingo) throws SemItensException{
		this.addItem(itemNovo);
		this.remItem(itemAtingo);
	}
	
	public double getTotal(){
		double total = 0;
		for(ItemDeVenda i : itens)
			total += i.getItem().getPreco()*i.getItem().getQuant();
		return total;
	}
	
	public Boolean contemItem(Item i){
		ItemDeVenda o = new ItemDeVenda(i);
		return itens.contains(o);
	}
}
