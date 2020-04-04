package Project4;


public class Plot {
	/**
	 * The x-value of the upper-left corner of the Plot
	 */
	private int x;
	/**
	 * The y-value of the upper-left corner of the Plot
	 */
	private int y;
	/**
	 * The horizontal extent of the Plot
	 */
	private int width;
	/**
	 * The vertical extent of the Plot
	 */
	private int depth;
	/**
	 * No-arg Constructor, creates a Plot with x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		//super();
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it.
	 * @param p - a Plot object
	 */
	public Plot(Plot p) {
		//super();
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	/**
	 * Parameterized Constructor
	 * @param x - horizontal coordinate of upper left corner
	 * @param y - vertical coordinate of upper left corner
	 * @param width - horizontal size
	 * @param depth - vertical size
	 */
	public Plot(int x, int y, int width, int depth) {
		//super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * takes a Plot instance and determines if it is overlapped by the current plot
	 * @param p a Plot object
	 * @return overlaps - true if overlap and false if not overlap
	 */
	public boolean overlaps (Plot p)
	{
		boolean overlaps = false;
		double x1 = x + 0.5*width;
		double x2 = p.x + 0.5*p.width;
		double y1 = y + 0.5*depth;
		double y2 = p.y + 0.5*p.depth;
		if(Math.abs(x1-x2) < 0.5*(width + p.width) && Math.abs(y1-y2) < 0.5*(depth + p.depth))
			overlaps = true;
		return overlaps;
	}
	/**
	 * takes a Plot instance and determines if the current plot contains it
	 * @param p a Plot object
	 * @return overlaps - true if encompassed and false if not encompassed
	 */
	public boolean encompasses (Plot p)
	{
		boolean encompasses = false;
		if(p.x >= x 
		&& p.x <= x+width 
		&& p.y >= y 
		&& p.y <= y+depth 
		&& p.x + p.width >= x 
		&& p.x + p.width <= x+width 
		&& p.y + p.depth >= y 
		&& p.y + p.depth <= y+depth)
			encompasses = true;
		return encompasses;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
	
	
	
}
