package sumas;

public class SumasVarias {

	private int x, y;

	public SumasVarias(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isPositive() {
		if (this.x>0 && this.y>0) {
			return true;
		}
		return false;
	}
	
	public int sumarPositivos() {
		if (this.x>0 || this.y>0) {
			return this.x+this.y;
		}
		return -1;
	}
	
}
