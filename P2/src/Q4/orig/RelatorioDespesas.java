package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	public void ImprimirRelatorio(Iterator<Despesa> despesas) {
		Calculadora calculadora = new Calculadora();
		float totalDespesa = calculadora.calculaTotal(despesas);

		String conteudo = formaConteudo(totalDespesa);
		imprime(conteudo);
	}
	
	public String formaConteudo(float totalDespesa){
		String conteudo = "Relat�rio de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
		return conteudo;
	}
	
	public void imprime(String conteudo) {
		SistemaOperacional so = new SistemaOperacional();
		so.getDriverImpressao().Imprimir(conteudo);
	}
	
}