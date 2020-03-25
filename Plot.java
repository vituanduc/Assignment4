
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	/** 
	 * No-arg Constructor, creates a Plot
	 *  with x=0, y=0, width=1, depth=1
	 *  */
	public Plot() {
		this.x=0;
		this.y=0;
		this.width=1;
		this.depth=1;
	}
	
	/** 
	 * Copy Constructor, creates a new Plot using the 
	 * information of the Plot passed to it.
	 * */
	public Plot(Plot p) {
		this.x=p.x;
		this.y=p.y;
		this.width=p.width;
		this.depth=p.depth;	
	}
	
	/** 
	 * Parameterized constructor
	 * @param x - horizontal coordinate of upper left corner
	 * @param y - vertical coordinate of upper left corner
	 * @param width - horizontal size
	 * @param depth - vertical size
	 * */
	public Plot(int x, int y, int width, int depth) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.depth=depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter
	 * Returns true if this plot overlaps the parameter, false otherwise
	 * @param n Plot object
	 * @return status
	 */
	public boolean overlaps(Plot p) {
		boolean status=true;
		if(this.x + this.width < p.x || p.x + p.width <this.x ||
	       this.y + this.depth < p.y || p.y + p.depth <this.y)
			status=false;		
		return status;		
	}
	
	/**
	 * Determines if this plot encompasses the parameter
	 * Returns true if this plot encompasses the parameter, false otherwise
	 * @param n Plot object
	 * @return status
	 */
	public boolean encompasses(Plot p) {
		boolean status=false;
		if(	x<=p.x && 
			y<=p.y && 
			x+width>=p.x+p.width && 
			y+depth>=p.y+p.depth )
			status=true;		
		return status;
	}
	
	/** 
	 * Return the x value
	 * @return x
	 */ 
	public int getX() {
		return x;
	}
	
	/** 
	 * Set the x value
	 * @param x
	 */
	public void setX(int x) {
		this.x=x;
	}
	
	/**
	 * Return the y value 
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Set the y value
	 * @param y
	 */
	public void setY(int y) {
		this.y=y;
	}
	
	/**Set the width value
	 * @param width
	 */
	public void setWidth(int width) {
		this.width=width;
	}
	
	/**Return the width value
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	
	/**Return the depth value
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}
	
	/**Set the depth value
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth=depth;
	}
	
	/**
	 * Prints out the name, city, owner and rent amount for a property
	 */
	public String toString() {
		String str = "Upper left: ("+x+","+y+"); Width: "+width+" Depth: "+depth;
		return str;		
	}
}



