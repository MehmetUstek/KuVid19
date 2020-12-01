package domain.utility;

public class Vector {

    int dx;
    int dy;
    double m;
    public Vector() {}
    
    public Vector(int x, int y) {
    	this.dx = x;
    	this.dy = y;
    	this.m = (double) this.dy/this.dx;
    }
    
    public Vector(String str) {
    	String[] tmp = str.split("]");
    	String[] tmp1 = tmp[0].split(",");
    	this.dx = Integer.parseInt(tmp1[0].split("=")[1]);
    	this.dy = Integer.parseInt(tmp1[1].split("=")[1]);
    	
    	
    }
    
    public void set(Vector v) {
    	this.setDx(v.getDx());
    	this.setDy(v.getDy());
    	this.m = (double) this.dy/this.dx;
    }
    
    public Vector add(Vector v) {
    	return new Vector(this.dx + v.dx, this.dy + v.dy);
    }

	public int getDx() {
		return this.dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return this.dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public double getM() {
		return this.m;
	}
	
	public double getUnitX() {
		return 1/(Math.pow(this.getM(),2) + 1);
	}
	
	public double getUnitY() {
		return (double) this.getM()*this.getUnitX();
	}

	@Override
	public String toString() {
		return "Vector [dx=" + dx + ", dy=" + dy + "]";
	}

   
}