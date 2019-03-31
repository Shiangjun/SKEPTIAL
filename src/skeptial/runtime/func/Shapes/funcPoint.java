package skeptial.runtime.func.Shapes;

public class funcPoint {
	public funcPoint(float _x, float _y){
		x = _x;
		y = _y;
	}
	public float x,y;
	
	public float dx,dy;
	
	public funcPoint clone(){
		return new funcPoint(x, y);
	}
}
