import java.text.DecimalFormat;

public class Property {

	private String propertyName;
	private String city;
	private double rentAmount;	
	private String owner;
	private Plot plot;
	
	/** No-arg Constructor, creates a new object with default
	 *  values of empty strings, 0 for rent amount, and default Plot
	 * */
	public Property() {
		propertyName = "";
		city="";
		owner="";
		rentAmount=0;
		plot = new Plot();
	}
	
	/**
	 * Copy Constructor, creates a new object using the
	 *  information of the object passed to it.
	 * @param p - a Property object
	 */
	public Property(Property p) {
		this.propertyName=p.propertyName;
		this.city=p.city;
		this.owner=p.owner;
		this.rentAmount=p.rentAmount;
		this.plot= new Plot();
		//plot.getX(), plot.getY(), 
		//plot.getWidth(), plot.getDepth()
	}
	
	/**
	 * Constructor, Parameterized constructor with no Plot information
	 * (uses default Plot where x,y are set to 0, width and depth set to 1)
	 * @param propertyName  property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount,
			String owner) {
		this.propertyName = propertyName;
		this.city=city;
		this.owner=owner;
		this.rentAmount=rentAmount;
		this.plot = new Plot();
	}
	
	/**
	 * Constructor, Parameterized constructor
	 * @param propertyName  property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount,
			String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city=city;
		this.owner=owner;
		this.rentAmount=rentAmount;
		this.plot = new Plot(x,y,width,depth);
	}
	
	/** Return the property Name
	 * @return propertyName
	 */
	public String getPropertyName(){
		return propertyName;		
	}
	
	/**Set the property name
	 * @param propertyName the propertyName to set
	 */ 
	public void setPropertyName(String propertyName) {
		this.propertyName=propertyName;
	}
	
	/**return the city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	
	/**set the city
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city=city;
	}
	/**return the rent amount
	 * @return rentAmount
	 */
	public double getRentAmount() {
		double rent= this.rentAmount;
		return rent;
	}
	
	/**set the rent amount
	 * @param rentAmount  the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	
	/** return the owner name
	 * @return owner
	 */
	public String getOwner(){
		return owner;
	}
	
	/**set the owner name 
	 * @param owner  the owner to set
	 */
	public void setOwner(String owner) {
		this.owner=owner;
	}
	
	/**set the Plot values
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x,y,width,depth);
		//plot.setX(x);
		//plot.setY(y);
		//plot.setWidth(width);
		//plot.setDepth(depth);
		return plot;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	
	/**Prints out the name, city, owner and rent amount for a property
	 * 	@Override
	 */
	public String toString(){
		DecimalFormat fmt = new DecimalFormat("0,0");
		String str = "Property Name: " + propertyName + "\n" + 
				"Located in " + city + "\n" + 
				"Belonging to: " + owner + "\n" + 
				"Rent Amount: " + rentAmount ;
		return str;
	}
	
}
