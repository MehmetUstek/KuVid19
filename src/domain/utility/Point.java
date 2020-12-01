package domain.utility;

public class Point {
	public int x;
	public int y;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	public double getDistance(Point p) {
		return Math.sqrt(Math.pow(p.x - this.x,2) + Math.pow(p.y - this.y, 2));
	}
	public Point add(Point p) {
		return new Point(p.x + this.x, p.y + this.y);
	}
	

	public String toString() {
		return "x=" + this.x + ", y=" + this.y;
	}
	public Point(String str) {
		String[] tmp = str.split(",");
		this.x = Integer.parseInt(tmp[0].split("=")[1]);
		this.y = Integer.parseInt(tmp[1].split("=")[1]);
		
	}
}
