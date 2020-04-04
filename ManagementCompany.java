package Project4;
public class ManagementCompany {
	/**
	 * maximum of the number of property held by management company
	 * a constant set to 5
	 */
	private final int MAX_PROPERTY = 5;
	/**
	 * the name of management company
	 */
	private String name;
	/**
	 * the tax ID of management company
	 */
	private String taxID;
	/**
	 * the management fee percentage
	 */
	private double mgmFeePer;
	/**
	 * a array hold objects of type of Property
	 */
	private Property[] properties;
	/**
	 * a object of type of Plot
	 */
	private Plot plot;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the taxID
	 */
	public String getTaxID() {
		return taxID;
	}
	/**
	 * @param taxID the taxID to set
	 */
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	/**
	 * @return the mgmFeePer
	 */
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	/**
	 * @param mgmFeePer the mgmFeePer to set
	 */
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}
	/**
	 * @return the properties
	 */
	public Property[] getProperties() {
		return properties;
	}
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}
	/**
	 * @return the plot
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * @param plot the plot to set
	 */
	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	/**
	 * @return the mAX_PROPERTY
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty strings and a default Plot.
	 * "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot();
	}
	/**
	 * Constructor Creates a ManagementCompany object using the passed informations. 
	 * "properties" array is initialized here as well.
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFeePer management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot();
	}
	
	/**
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFeePer management fee
	 * @param x The x-value of the upper-left corner of the Plot
	 * @param y The y-value of the upper-left corner of the Plot
	 * @param width The horizontal extent of the Plot
	 * @param depth The vertical extent of the Plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth ) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x,y,width,depth);
	}
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. 
	 * "properties" array is initialized here as well.
	 * @param otherCompany a ManagementCompany object
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		super();
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
		for (int i = 0;i < MAX_PROPERTY;i++) {
			properties[i] = otherCompany.properties[i];
		}
		this.plot = new Plot(otherCompany.plot);
	}
	/**
	 * addProperty methods
	 * @param property a Property object
	 * @return indicator 
	 */
	public int addProperty (Property property) {
		int indicator=-1;
		if (property.getPropertyName() == null) 
			indicator = -1;
		else if (properties[MAX_PROPERTY-1]!=null)
			indicator = -2;
		else if (!plot.encompasses(property.getPlot()))
			indicator = -3;
		else {
			for(int i=0;i<properties.length;i++) {
				if (properties[i]==null) {
					properties[i] = property; 
					indicator = i;
					break;
				}
				else if (properties[i].getPlot().overlaps(property.getPlot())) {
					indicator = -4;
					break;
				}
			}
		}
		return indicator;
	}
	/**
	 * addProperty methods
	 * @param propertyName name of property
	 * @param city name of city
	 * @param rent amount of rent
	 * @param ownerName name of owner
	 * @return return the index of the array where the property is added, 
	 * -1 if the property is not added,
	 * -2 if the parameter is null, 
	 * -3 if the array is full, 
	 * -4 if if the plot for the property overlaps any other property’s plot
	 */
	public int addProperty (String propertyName, String city, double rent, String ownerName) {
		Property property = new Property(propertyName, city, rent, ownerName);
		int indicator=-1;
		if (property.getPropertyName() == null) 
			indicator = -1;
		else if (properties[MAX_PROPERTY-1]!=null)
			indicator = -2;
		else if (!plot.encompasses(property.getPlot()))
			indicator = -3;
		else {
			for(int i=0;i<properties.length;i++) {
				if (properties[i]==null) {
					properties[i] = property; 
					indicator = i;
					break;
				}
				else if (properties[i].getPlot().overlaps(property.getPlot())) {
					indicator = -4;
					break;
				}
			}
		}
		return indicator;
	}
	/**
	 * addProperty methods
	 * @param propertyName name of property
	 * @param city name of city
	 * @param rent amount of rent
	 * @param ownerName name of owner
	 * @param x The x-value of the upper-left corner of the Plot
	 * @param y The y-value of the upper-left corner of the Plot
	 * @param width The horizontal extent of the Plot
	 * @param depth The vertical extent of the Plot
	 * @return return the index of the array where the property is added, 
	 * -1 if the property is not added,
	 * -2 if the parameter is null, 
	 * -3 if the array is full, 
	 * -4 if if the plot for the property overlaps any other property’s plot
	 */
	public int addProperty (String propertyName, String city, double rent, String ownerName,
			int x,int y, int width, int depth) {
		Property property = new Property(propertyName, city, rent, ownerName,x,y,width,depth);
		int indicator=-1;
		if (property.getPropertyName() == null) 
			indicator = -1;
		else if (properties[MAX_PROPERTY-1]!=null)
			indicator = -2;
		else if (!plot.encompasses(property.getPlot()))
			indicator = -3;
		else {
			for(int i=0;i<properties.length;i++) {
				if (properties[i]==null) {
					properties[i] = property; 
					indicator = i;
					break;
				}
				else if (properties[i].getPlot().overlaps(property.getPlot())) {
					indicator = -4;
					break;
				}
			}
		}
		return indicator;
	}
	/**
	 * A method totalRent– returns the total rent of the properties in the properties array.
	 * @return totalRent the total rent of the properties in the properties array
	 */
	public double totalRent(){
		double totalRent = 0;
		for (int i=0;i<properties.length && properties[i]!=null;i++) {
			totalRent +=properties[i].getRentAmount();
		}
		return totalRent;
	}
	/**
	 * A method maxPropertyRent-returns the String representation of the property within the properties array that has the highest fee amount. 
	 * For simplicity assume that each "Property" object's fee amount is different.  
	 * @return maxPropertyRent the String representation of the property within the properties array that has the highest fee amount
	 */
	public String maxPropertyRent() {
		String maxPropertyRent = new String();
		maxPropertyRent = displayPropertyAtIndex(maxPropertyIndex());
		return maxPropertyRent ;
	}
	/**
	 * A method maxPropertyRent-returns the index of the property within the properties array that has the highest fee amount. 
	 * For simplicity assume that each "Property" object's fee amount is different. 
	 * @return maxPropertyIndex the index of the property within the properties array that has the highest fee amount
	 */
	private int maxPropertyIndex() {
		int maxPropertyIndex=0;
		double maxRentAmout = properties[0].getRentAmount();
		for (int i=0;i<properties.length && properties[i]!=null;i++) {
			if(properties[i].getRentAmount()>maxRentAmout) {
				maxRentAmout = properties[i].getRentAmount();
				maxPropertyIndex = i;
			}
		}
		return maxPropertyIndex ;
	}
	/**
	 * a method displayPropertyAtIndex prints information of the property within the properties array.
	 * @param index the index of properties
	 * @return the string representation of the property within the properties array
	 */
	private String displayPropertyAtIndex(int index) {
		return properties[index].toString();
	}
	/**
	 * a method displayAllProperties prints information of all objects of type of Property within the properties array.
	 * @return the string representation of all objects of type of Property
	 */
	private String displayAllProperties() {
		String displayAllProperties = new String();
		for (int i=0;i<properties.length && properties[i]!=null;i++) 
			displayAllProperties +=displayPropertyAtIndex(i);
		return displayAllProperties;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "List of the properties for " + name + ", taxID: " + taxID
	+ "\n__________________________________________________________\n" 
	+ displayAllProperties()
	+ "\n__________________________________________________________";
	}
	
	
}
	
	
