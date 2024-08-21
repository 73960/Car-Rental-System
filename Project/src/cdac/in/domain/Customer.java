package cdac.in.domain;

public class Customer
{
	private String customerName;
	private String emialId;
	private int contactNo;
	private int hours;
	private double bill;
	
	public Customer()
	{
		
	}

	public Customer(String customerName, String emialId, int contactNo, int hours) 
	{
		this.customerName = customerName;
		this.emialId = emialId;
		this.contactNo = contactNo;
		this.hours = hours;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	public String getEmialId() 
	{
		return emialId;
	}

	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill)
	{
		this.bill = bill;
	}
	
	@Override
	public String toString()
	{
		
		return String.format("%-15s%-20s%-10d%-5d%-5.2f",this.customerName,this.emialId,this.contactNo,this.hours,this.bill);
	}
}
