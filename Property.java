package Project4;

public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	/**
	 * No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot
	 */
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p a Property object
	 */
	public Property(Property p) {
		
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = p.plot;
	}
	/**
	 * Parameterized Constructor, no Plot information provided
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount,  String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	/**
	 * Constructor, Parameterized constructor
	 * @param city city where the property is located
	 * @param owner the owner's name
	 * @param propertyName property name
	 * @param rentAmount rent amount
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		super();
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x,y,width,depth);
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * @param rentAmount the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	/**
	 * setter method for Plot
	 * @param x The x-value of the upper-left corner of the Plot
	 * @param y The y-value of the upper-left corner of the Plot
	 * @param width The horizontal extent of the Plot
	 * @param depth The vertical extent of the Plot
	 */
	public void setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * Prints out the name, city, owner and rent amount for a property. 
	 */
	@Override
	public String toString() {
		return "\nProperty Name: " + propertyName + "\n Located in " + city +
				"\n Belonging to: " + owner + "\n Rent Amount: " + rentAmount;
	}
	
	
	
	
	
	
}
