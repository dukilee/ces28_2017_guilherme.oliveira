package utm_v1;

import java.util.ArrayList;

public class GCS {
	private Drone myDrone;
	ArrayList<Position> saInfo;
	
	public GCS(Drone myDrone){
		this.myDrone = myDrone;
	}
	
	public Drone getMyDrone(){
		return myDrone;
	}

	public void update(ArrayList<Position> saInfo) {
		//Now the system should transmit to the GCS
		this.saInfo = saInfo;
	}
	
	public ArrayList<Position> getSaInfo(){
		return saInfo;
	}
}
