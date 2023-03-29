public class Square extends Rectangle {
	public Square() {
		super(1.0,1.0);
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public void setSide(double side) {
		super.setHeight(side);
		super.setWidth(side);		
	}
	
	public double getSide() {
		return this.getHeight();
	}
	
	public String toString() {
		//"A Square with side=xxx, which is a subclass of yyy", 
		// where yyy is the output of the toString() method from the superclass.
		// is also acceptable
		return "Square[" + super.toString()  + "]";
	}
	
	/* override these to prevent any code from violating the square geometry */
	
	public void setWidth(double width) {
		this.setSide(width);
	}
	
	public void setLength(double length) {
		this.setSide(length);
	}

}
