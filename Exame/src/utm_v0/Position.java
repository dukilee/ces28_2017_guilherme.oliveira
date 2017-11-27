package utm_v0;

public class Position {
	public double x, y, z;
	public Position(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Position(){
		x = y = z = 0;
	}
	
	public String toString(){
		return "(" + (new Double(x)).toString() + ", "
				+(new Double(y)).toString() + ", "
				+(new Double(z)).toString() + ")";
		
	}
	
}
