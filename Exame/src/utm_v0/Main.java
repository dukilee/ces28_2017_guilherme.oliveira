package utm_v0;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		Server s = new Server();
		
		//adding 3 drones and their correspondent gcs
		for(int i = 0; i<3; i++){
			Drone aux = new Drone();
			s.addDrone(aux);
			s.addGCS(new GCS(aux));
		}
		
		//update the position and prints the position of each drone for 10 iterations
		for(int i = 0; i<10; i++){
			System.out.print("Iteration "+(i+1)+": {");
			s.update();
			ArrayList<Position> aux = s.getSaInfo();
			for(int j = 0; j<aux.size(); j++){
				if(j!=0) System.out.print(", ");
				System.out.print(aux.get(j).toString());
			}
			System.out.println("}");
		}
		
	}
}
