package utm_v0;

import java.util.ArrayList;

public class GCS {
	private Drone myDrone;
	
	public GCS(Drone myDrone){
		this.myDrone = myDrone;
	}
	
	public Drone getMyDrone(){
		return myDrone;
	}

	public void update(ArrayList<Position> saInfo) {
		//Now the system should transmit to the GCS
	}
}
