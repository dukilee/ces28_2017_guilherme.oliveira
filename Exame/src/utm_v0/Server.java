package utm_v0;

import java.util.ArrayList;

public class Server {

	ArrayList<Drone> drones;
	ArrayList<GCS> gcs;
	ArrayList<Position> saInfo;
	
	
	public Server(){
		drones = new ArrayList<Drone>();
		gcs = new ArrayList<GCS>();
		saInfo = new ArrayList<Position>();
		
	}
	
	public void addDrone(Drone drone){
		this.drones.add(drone);
	}
	
	public void addGCS(GCS g){
		this.gcs.add(g);
	}
	
	public void update(){
		//update saInfo
		saInfo = UTM_CTR.getInstance().update(drones);
		
		//send info to each gcs
		for(GCS g : gcs){
			g.update(saInfo);
		}
	}
	
	public ArrayList<Position> getSaInfo(){
		return saInfo;
	}
	
}
