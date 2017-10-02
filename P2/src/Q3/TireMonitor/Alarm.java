package Q3.TireMonitor;

public class Alarm{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    AbstractSensor sensor;

    boolean alarmOn;
    
    public Alarm(AbstractSensor sensor){
    	this.sensor = sensor;
    	alarmOn = false;
    }
    
    public void check(){
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue){
            alarmOn = true;
        }
    }

    public boolean isAlarmOn(){
        return alarmOn; 
    }
}