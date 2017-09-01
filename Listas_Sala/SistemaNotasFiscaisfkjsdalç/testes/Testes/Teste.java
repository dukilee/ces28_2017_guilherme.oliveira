package Testes;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;

import excecoes.ItemInexistenteException;
import excecoes.SemItensException;

import bd.BDCliente;
import bd.BDProdutos;
import bd.Cadastro;
import bd.Cliente;
import bd.ItemDeVenda;
import bd.Produto;
import bd.Servico;
import sistema.NotaFiscal;
import sistema.VerificadorCPF;

public class Teste {
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	@Mock private VerificadorCPF verificador;
	@Mock private BDCliente bdCliente;

	Produto p;
	Produto p2;
	Servico s;
	Servico s2;
	NotaFiscal notaFiscal;
	
	@Before
	public void setUp() throws Exception {
		cliente1 = new Cliente(1);
		cliente2 = new Cliente(2);
		cliente3 = new Cliente(3);
		bdCliente = Mockito.mock(BDCliente.class);
		verificador = Mockito.mock(VerificadorCPF.class);
		Mockito.when(verificador.verifica(1)).thenReturn(true);
		Mockito.when(verificador.verifica(2)).thenReturn(false);
		
		p = new Produto("Guiso", 3, 5);
		p2 = new Produto("Gafanhoto", 1, 9);
		s = new Servico("Guincho", 2, 2.30);
		s2 = new Servico("Guilhotina", 2, 2.30);	//nao esta no BDProdutos
		
		BDProdutos bdProdutos = Mockito.mock(BDProdutos.class);
		Mockito.when(bdProdutos.contem(p)).thenReturn(true);
		Mockito.when(bdProdutos.contem(p2)).thenReturn(true);
		Mockito.when(bdProdutos.contem(s)).thenReturn(true);
		Mockito.when(bdProdutos.contem(s2)).thenThrow(new SemItensException());   
		notaFiscal = new NotaFiscal(cliente1, 2002, p, bdProdutos);
	}
	
	@Test
	public void addingOKPeopleToBD(){
		//pessoas com cpf ok
		Cadastro cadastro = new Cadastro(verificador, bdCliente);
		
		cadastro.cadastrar(cliente1);
		Mockito.verify(verificador, Mockito.times(1)).verifica(cliente1.getCpf());
		
		assertTrue(cadastro.cadastrado(cliente1));
		assertFalse(cadastro.cadastrado(cliente2));
	}
	
	@Test
	public void addingBadPeopleToBD(){
		//pessoas com cpk sujo
		Cadastro cadastro = new Cadastro(verificador, bdCliente);
		
		cadastro.cadastrar(cliente2);
		Mockito.verify(verificador, Mockito.times(1)).verifica(cliente2.getCpf());
		
		assertFalse(cadastro.cadastrado(cliente1));
		assertFalse(cadastro.cadastrado(cliente2));
		
	}
	
	
	@Test
	public void creatingFiscalNote(){	
		try{
			assertTrue((double) 15 == notaFiscal.getTotal());
			assertTrue(notaFiscal.contemItem(p));
			assertFalse(notaFiscal.contemItem(p2));
			assertFalse(notaFiscal.contemItem(s));
			
			notaFiscal.addItem(p2);
			assertTrue((double) 24 == notaFiscal.getTotal());
			assertTrue(notaFiscal.contemItem(p));
			assertTrue(notaFiscal.contemItem(p2));
			assertFalse(notaFiscal.contemItem(s));

			notaFiscal.addItem(s);
			assertTrue(28.60 == notaFiscal.getTotal());
			assertTrue(notaFiscal.contemItem(p));
			assertTrue(notaFiscal.contemItem(p2));
			assertTrue(notaFiscal.contemItem(s));

			notaFiscal.remItem(p2);
			assertTrue(19.60 == notaFiscal.getTotal());
			assertTrue(notaFiscal.contemItem(p));
			assertFalse(notaFiscal.contemItem(p2));
			assertTrue(notaFiscal.contemItem(s));

			notaFiscal.remItem(p2);
			assertTrue(19.60 == notaFiscal.getTotal());
			assertTrue(notaFiscal.contemItem(p));
			assertFalse(notaFiscal.contemItem(p2));
			assertTrue(notaFiscal.contemItem(s));

			notaFiscal.remItem(p);
			assertTrue(4.60 == notaFiscal.getTotal());
			assertFalse(notaFiscal.contemItem(p));
			assertFalse(notaFiscal.contemItem(p2));
			assertTrue(notaFiscal.contemItem(s));
			
			notaFiscal.remItem(p);
		}catch (Exception e){
			//nao pode dar exceçao
			fail("Nao pode dar excecao");
		}
	}
	
	@Test(expected = SemItensException.class)
	public void remobingLastItemFromNF() throws SemItensException{
		notaFiscal.remItem(p);
	}

	
	@Test
	public void changingOneItemFromNF(){
		try{
			assertTrue(notaFiscal.contemItem(p));
			assertFalse(notaFiscal.contemItem(s));
			assertTrue(15 == notaFiscal.getTotal());
			notaFiscal.trocaItem(s, p);
			assertTrue(notaFiscal.contemItem(s));
			assertFalse(notaFiscal.contemItem(p));
			assertTrue(4.6 == notaFiscal.getTotal());
		}catch(SemItensException e){
			fail("Nao pode dar excecao");
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void inexistingProduct() throws NullPointerException{
		notaFiscal.addItem(s2);
	}
	
}
