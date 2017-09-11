package Q4.ptc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class aTest {
	@Mock private Sensor sensor;
	@Mock PainelCondutor painelCondutor;
	@Mock Datacenter datacenter;
	
	@Before
	public void setup(){
		sensor = Mockito.mock(Sensor.class);
		painelCondutor = Mockito.mock(PainelCondutor.class);
		datacenter = Mockito.mock(Datacenter.class);
	}
	
	
	@Test
	public void itemA(){
		ControladorPTC controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
	}

	@Test
	public void itemB(){
		Double velocidade = new Double(30);
		Mockito.when(sensor.isCruzamento()).thenReturn(false);
		Mockito.when(sensor.getVelocidade()).thenReturn(velocidade);
		
		ControladorPTC controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
		controlador.run();
		Mockito.verify(painelCondutor, Mockito.times(1)).imprimirAviso(velocidade.toString(), 1);
		Mockito.verify(datacenter, Mockito.times(1)).gerarRelatorio(velocidade.toString());
	}

	@Test
	public void itemC(){
		Double velocidade = new Double(120);
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(velocidade);
		Mockito.when(painelCondutor.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		
		ControladorPTC controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
		controlador.run();
		Mockito.verify(painelCondutor, Mockito.times(1)).imprimirAviso("Velocidade alta", 1);
	}
	
	@Test
	public void itemD(){
		Double velocidade = new Double(10);
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(sensor.getVelocidade()).thenReturn(velocidade);
		Mockito.when(painelCondutor.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		
		ControladorPTC controlador = new ControladorPTC(sensor, datacenter, painelCondutor);
		controlador.run();
		Mockito.verify(painelCondutor, Mockito.times(2)).imprimirAviso("Velocidade Baixa", 1);
	}
	
	

	
}
