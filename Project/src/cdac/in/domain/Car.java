package cdac.in.domain;

import java.util.Objects;

public class Car 
{
	private int carId;
	private String carModel;
	private String carType;
	private int noOfSeats;;
	private	float mileage;
	private String condition;
	private int rentPerHour;
	private boolean rentedStatus;
	
	public Car()
	{
		
	}

	public Car(int carId, String carModel, String carType, int noOfSeats, float mileage, String condition,int rentPerHour, boolean rentedStatus)		
	{
		this.carId = carId;
		this.carModel = carModel;
		this.carType = carType;
		this.noOfSeats = noOfSeats;
		this.mileage = mileage;
		this.condition = condition;
		this.rentPerHour = rentPerHour;
		this.rentedStatus = rentedStatus;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public float getMileage() {
		return mileage;
	}

	public void setMileage(float mileage) {
		this.mileage = mileage;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getRentPerHour() {
		return rentPerHour;
	}

	public void setRentPerHour(int rentPerHour) {
		this.rentPerHour = rentPerHour;
	}

	public boolean isRentedStatus() {
		return rentedStatus;
	}

	public void setRentedStatus(boolean rentedStatus) {
		this.rentedStatus = rentedStatus;
	}

	@Override
	public int hashCode()
	{
		
		final int prime = 31;
		int result = 1;
		result = prime * result + carId;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carId != other.carId)
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		
		return String.format("%-4s%-25s%-15s%-5d%-10.2f%-15s%-10d%-10b",this.carId,this.carModel,this.carType,this.noOfSeats,this.mileage,this.condition,this.rentPerHour,this.rentedStatus);
	}

	public boolean getRentedStatus() 
	{
		return rentedStatus;
	}
}
