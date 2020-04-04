import javafx.scene.layout.Region;

public class ManagementCompany {

	private String name; //Name of the management company
	private String taxID; //tax ID of the management Company
	private final int MAX_PROPERTY=	5; //Maximum number of properties that this management company handles
	private Property[] properties; //An array of Property objects
	private double mgmFeePer; // management fee percentage	
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	private Plot plot; //Plot of the ManagemntCompany
	private double mgmFee;
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty 
	 * strings and a default Plot. "properties" array is initialized here as well.
	 */
	ManagementCompany(){
		name="";	
		taxID="";
		mgmFeePer=0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	/**Constructor Creates a ManagementCompany object using the passed information. 
	 * Mgmt Co plot is initialized to default Plot. "properties" array is initialized
	 *  here as well.
	 * @param name  management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 */
	ManagementCompany(String name, String taxID, double mgmFee){
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];

	}
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * "properties" array is initialized here as well.
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	ManagementCompany(String name, String taxID, double mgmFee,
			int x, int y, int width, int depth){
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFee;
		plot = new Plot(x,y,width,depth);
		this.properties = new Property[MAX_PROPERTY];

	}
	
	/**
	 * Copy Constructor creates a ManagementCompany object using another
	 * ManagementCompany object. "properties" array is initialized here as well.
	 * @param otherCompany
	 */
	ManagementCompany(ManagementCompany otherCompany){
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
		for (int i = 0;i < MAX_PROPERTY;i++) {
			properties[i] = otherCompany.properties[i];
		}
		this.plot = new Plot(otherCompany.plot);
	}
	
	/**Return the MAX_PROPERTY constant that represent the size of 
	 * the "properties" array.
	 * @return MAX_PROPERTY a constant attribute for this class that is set 5
	 */
	public int getMAX_PROPERTY() {
		int max=MAX_PROPERTY;
		return max;
	}
	
	/**
	 * Adds the property object to the "properties" array.
	 * @param property
	 * @return status Returns either 
	 * -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		int status=0;
		if(properties[MAX_PROPERTY-1]!=null) {
			status=-1;
		}
		else if(property==null) {
			status=-2;		
		}
		else if (!plot.encompasses(property.getPlot()))
				status = -3;
		else {
			for(int i=0;i<properties.length;i++) {
				if (properties[i]==null) {
					properties[i] = property; 
					status = i;
					break;
					}
				else if (properties[i].getPlot().overlaps(property.getPlot())) {
					status = -4;
					break;
				}
			}
		}	
		return status;
	}
			
	
	/**
	 * Creates a property object and adds it to the "properties" array, 
	 * in a default plot.
	 * @param name property name
	 * @param city location of the property
	 * @param rent monthly rent
	 * @param owner owner of the property
	 * @return status Returns either 
	 * -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner) {
		int status=0;
		Property property = new Property(name, city, rent, owner);
		if(properties[MAX_PROPERTY-1]!=null) {
			status=-1;
		}
		else if (!plot.encompasses(property.getPlot()))
			status = -3;
	else {
		for(int i=0;i<properties.length;i++) {
			if (properties[i]==null) {
				properties[i] = property; 
				status = i;
				break;
				}
			else if (properties[i].getPlot().overlaps(property.getPlot())) {
				status = -4;
				break;
			}
		}
	}	
	return status;
}
	
	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param name  property name
	 * @param city  location of the property
	 * @param rent  monthly rent
	 * @param owner owner of the property
	 * @param x x location of upper left corner of property's plot
	 * @param y y location of upper left corner of property's plot
	 * @param width width of the property's plot
	 * @param depth depth of the property's plot
	 * @return status Returns either 
	 * -1 if the array is full, 
	 * -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth) {
		int status=0;
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		//property.setPlot(x,y,width,depth);
		//int x1=property.getPlot().getX(), y1=property.getPlot().getY(), w1=property.getPlot().getWidth(), d1=property.getPlot().getDepth();
		if(properties[MAX_PROPERTY-1]!=null) {
			status=-1;
		}
		else if (!plot.encompasses(property.getPlot()))
			status = -3;
		else {
			for(int i=0;i<properties.length;i++) {
				if (properties[i]==null) {
					properties[i] = property; 
					status = i;
					break;
					}
				else if (properties[i].getPlot().overlaps(property.getPlot())) {
					status = -4;
					break;
				}
			}
		}	
	return status;
}
	
	/**
	 * This method accesses each "Property" object within the array "properties" 
	 * and sums up the property rent and returns the total amount.
	 * @return total the total rent
	 */
	public double totalRent() {
		double total=0;
		for(int i = 0; i<MAX_PROPERTY && properties[i]!=null ; i++) {
			total+=properties[i].getRentAmount();
		}
		total=total*1.0;
		return total;
	}

	/**
	 * This method finds the index of the property with the maximum rent amount. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return  the maximum rent amount
	 */
	public String maxRentProp() {
		double maxRent=properties[0].getRentAmount();
		int a=0;
		for(int i=1; i<MAX_PROPERTY && properties[i]!=null; i++ ) {
			if(properties[i].getRentAmount()>maxRent) {
				maxRent=properties[i].getRentAmount();
				i=a;
			}			
		}
		String str= properties[a].toString();
				//Double.toString(maxRent);
		return str;

	}

	
	/**
	 * This method finds the index of the property with the maximum rent amount. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different
	 * @return index the index of the property with the maximum rent amount
	 */
	public int maxRentPropertyIndex() {
		double maxRent=properties[0].getRentAmount();
		int index=0;
		for(int i=1; i<MAX_PROPERTY && properties[i]!=null; i++ ) {
			if(properties[i].getRentAmount()>maxRent) {
				maxRent=properties[i].getRentAmount();
				index=i;
			}			
		}			
		return index;
	}
	
	/**
	 * Displays the information of the property at index i
	 * @param i The index of the property within the array "properties"
	 * @return str information of the property at index i
	 */
	public String displayPropertyAtIndex(int i){
		String str=properties[i].toString();
		return str;
	}
	
	/**
	 * Displays the information of all the properties in the "properties" array.
	 * @return str information of all the property 
	 */
	public String toString(){	
		String str="List of the properties for " + name + ", taxID: " + taxID + "\n" + 
				"  ______________________________________________________\n";
		for(int i = 0; i<MAX_PROPERTY && properties[i]!=null; i++ ) {
			str+=displayPropertyAtIndex(i);
			str+=("\n");
		}
		mgmFee=totalRent()*mgmFeePer/100;
		str += " ______________________________________________________;\n" + 
				"  total management Fee: " + mgmFee;
		
		return str;		
	}
	
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}
	
	public Property[] getProperties() {
		return properties;
	}
	
	public Plot getPlot() {
		return plot;
	}

}
