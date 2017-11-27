package utm_v1;

import java.util.ArrayList;

public class UTM_CTR {//singleton
	ArrayList<Position> saInfo;
	private static UTM_CTR i = new UTM_CTR();

	private UTM_CTR(){//private constructor
		saInfo = new ArrayList<Position>();
	}
	
	public static UTM_CTR getInstance(){
		return i;
	}

	public ArrayList<Position> update(ArrayList<Drone> drones) {
		saInfo.clear();//clear info from last iteration
		
		for(Drone it : drones){
			saInfo.add(it.getStatus());
		}
		
		return saInfo;
	
	}

}
