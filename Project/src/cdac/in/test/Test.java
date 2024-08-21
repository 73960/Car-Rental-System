package cdac.in.test;

import java.util.Map.Entry;
import java.util.Set;
import java.util.LinkedHashMap;
import cdac.in.domain.Car;
import cdac.in.domain.Customer;
import cdac.in.main.Program;

public class Test 
{
	private static int carId = 11;
	private static double bill = 0.0;
	private LinkedHashMap<Car, Customer> map = new LinkedHashMap<>();
	public void addEntries(Car[] keys, Customer[] values)
	{
		if( this.map != null ) {
			for( int index = 0; index < keys.length; ++ index ) {
				Car key = keys[ index ];
				Customer value = values[ index ];
				this.map.put(key, value);
			}
		}
		
	}
	
	public void displayCars() 
	{
		System.out.println("                                     ***** CAR RENTAL SYSTEM *****                           ");  
		System.out.println();
		System.out.printf("%-5s %-24s %-9s %-5s %-8s %-12s %-12s %s\n","ID","Model" ,"Type" ,"Seats","Mileage","Condition","Rent/Hour","Reserved" );
		System.out.println("------------------------------------------------------------------------------------------------");
		if( this.map != null ) {
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) {
				Car key = entry.getKey();
				Customer value = entry.getValue();
				System.out.println(key);
			}
		}
		
	}
	
	public Boolean bookCar(int carId2)
	{
		
		if( this.map != null ) {
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) {
				Car key = entry.getKey();
				if(key.getCarId()==carId2){
					
					if(key.getRentedStatus()==false) {
						Customer newCustomer = new Customer();
						Program.acceptRecord(newCustomer);					
						key.setRentedStatus(true);
						map.put(key,newCustomer);
						return true;
					}
					else
						System.out.println("Car is Already Booked!");
				}
			}
		}
		return false;
	}
	
	public boolean generateBill(String email)
	{
		if( this.map != null ) 
		{
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) {
				Car key = entry.getKey();
				Customer value = entry.getValue();
				if(value!=null && value.getEmialId().equals(email)) {
					value.setBill(key.getRentPerHour()*value.getHours());
					System.out.println("--------------------------------");
					System.out.println("Car Rented : "+key.getCarModel());
					System.out.println("Duration : "+value.getHours()+" Hours");
					System.out.println("Your Bill : "+value.getBill()+" Rupees");
					System.out.println("--------------------------------");
					bill= value.getBill() + bill;
					return true;					
				}				
			}			
		}
		return false;	
		
	}
	
	public boolean returnCar(String email) 
	{
		if( this.map != null ) {
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) {
				Car key = entry.getKey();
				Customer value = entry.getValue();
				if(value!=null && value.getEmialId().equals(email)) {
					if(value.getBill()!=0.0) {
					this.map.put(key, null);
					System.out.println("Car returned Successfully!!");
					return true;
					}
					else
						System.out.println("Please Generate Bill!");
					return true;
				}
			}
		}
		return false;
	}
	
	public void addCar(Car car) 
	{
		if(this.map!=null) {
			this.map.put(car,null);
			car.setCarId(carId);
			carId ++ ;
			System.out.println("Car Added Successfully!!");
		}
		
	}
	//Get the key(reference) of car instance which is to be deleted
	//Cannot delete key directly using remove method while iterating Otherwise ConcurrentModificationException will occur
	public Car getCarKey(int carId2) 
	{
		if( this.map != null ) {
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) {
				Car key = entry.getKey();
				Customer value = entry.getValue();
				if(key.getCarId()==carId2) {
					if(value==null) {
						Car car = key;
						return car;
					}
					else
						System.out.println("Car is Booked!");
				}		
			}
		}
		return null;
	}
	
	
	public void removeCar(Car car)
	{
		Car key = car;
		this.map.remove(key);
		System.out.println("Car Removed Successfully!!");
	}
	
	
	public void printEntries() 
	{
		System.out.printf("%-5s %-24s %-9s %-5s %-8s %-12s %-11s %-12s%-18s %-15s %-12s%-8s\n","ID","Model" ,"Type" ,"Seats","Mileage","Condition","Rent/Hour","Reserved", "Customer Name" ,"Email ID" ,"Contact No","Bill");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
		if( this.map != null )
		{
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) 
			{
				Car key = entry.getKey();
				Customer value = entry.getValue();
				System.out.println(key+" "+value);
			}
		}
	}
	
	
	public void displayCustomers()
	{
		System.out.printf("%-18s %-14s %-12s%-2s\n","Customer Name" ,"Email ID" ,"Contact No","Bill");
		System.out.println("-----------------------------------------------------");
		if( this.map != null ) 
		{
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) 
			{
				Car key = entry.getKey();
				Customer value = entry.getValue();
				if(value!=null)
					System.out.println(value);
			}
		}	
		
	}
	
	
	public void generateReport()
	{
		//double sum=0;
		int carCount=0;
		int carOnRent=0;
		if( this.map != null ) 
		{
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) {
				Car key = entry.getKey();
				Customer value = entry.getValue();
				carCount++;
				if(value!=null) {
					//sum= value.getBill() + sum;
					carOnRent++;
				}
			}
			System.out.println("Report");
			System.out.println("--------------------------");
			System.out.println("Total Revenue 	: "+bill);
			System.out.println("Total Car count : "+carCount);
			System.out.println("Cars on Rent 	: "+carOnRent);		
		}
		
	}
	
	
	public boolean isCarAdded(int carId2) 
	{
		if( this.map != null ) {
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries)
			{
				Car key = entry.getKey();
				Customer value = entry.getValue();
				if(key.getCarId()==carId2)
					return true;
			}
		}
		return false;
	}
	
	
	public void modifyRate(int carId2, int newRate)
	{
		if( this.map != null )
		{
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) 
			{
				Car key = entry.getKey();
				int newRate1;
				if(key.getCarId()==carId2) 
					key.setRentPerHour(newRate);
			}
		}
		
	}

	public void modifyCondition(int carId, String condition)
	{
		
		if( this.map != null )
		{
			Set<Entry<Car, Customer>> entries = this.map.entrySet();
			for (Entry<Car, Customer> entry : entries) 
			{
				Car key = entry.getKey();
			
				if(key.getCarId()==carId) 
					key.setCondition(condition);
			}
		}
	}
		
}
	
	
	

