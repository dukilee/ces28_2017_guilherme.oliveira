package Q3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import Q3.TireMonitor.AbstractSensor;
import Q3.TireMonitor.Alarm;

public class TestsAlarm {
	AbstractSensor sensor;
	
	@Before
	public void setUp(){
		sensor = Mockito.mock(AbstractSensor.class);
	}
	
	@Test
	public void testAlarmForLowPressure() {
		Alarm alarm = new Alarm(sensor);
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 15);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	@Test
	public void testAlarmForIntermediatePressure() {
		Alarm alarm = new Alarm(sensor);
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 19);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	@Test
	public void testAlarmForHighPressure() {
		Alarm alarm = new Alarm(sensor);
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 23);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	@Test
	public void testIfAlarmTurnsOff() {
		Alarm alarm = new Alarm(sensor);
		//should be off
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 19);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
		
		//high pressure, so it turns on
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 23);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		
		//is already on, so should keep it
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 19);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		
		//is already on, so should keep it
		when(sensor. popNextPressurePsiValue()).thenReturn((double) 23);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
				
	}
	

}
