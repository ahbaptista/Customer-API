package global;

public interface Messages {
	public static final String CUST_200 = "Returns the ordered list of customers";
	public static final String CUST_MISS_FIELDS = "Missing fields";
	public static final String CUST_INV_DATE = "Invalid date format";
	public static final String CUST_INV_FORMAT = "Invalid instace Type";
	public static final String CUST_400 = CUST_MISS_FIELDS + " / " + CUST_INV_DATE + " / " + CUST_INV_FORMAT;
	public static final String CUST_500 = "Internal server error";
	public static final String CUST_EDP = "Customers Endpoint";
	public static final String CUST_DESC = "Orders a given Customer List by duetime field";
}