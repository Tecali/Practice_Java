
public class Coordinate {
	private int x;
	private int y;
	private String name;
	
	public Coordinate(int x, int y, String name){
		this.x= x;
		this.y = y;
		this.name = name;
	}
	public Coordinate(int i, int j) {
		this.x=i;
		this.y=j;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
