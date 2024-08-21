package cdac.in.main;
import java.util.Scanner;
 
import cdac.in.domain.Car;
import cdac.in.domain.Customer;
import cdac.in.test.Test;
public class Program {

	private static Car[] getKeys() 
	{
		Car[] arr = new Car[ 10 ];
		arr[ 0 ] = new Car(1,"Maruti Swift","Hatchback",5,23.20f,"Good",120,true);
		arr[ 1 ] = new Car(2,"Hyundai i20","Hatchback",5,20.35f,"Average",140,true);
		arr[ 2 ] = new Car(3,"Honda Amaze","Sedan",5,18.3f,"Good",150,false);
		arr[ 3 ] = new Car(4,"Toyota Innova Crysta","MPV",8,11.25f,"Best",200,false);
		arr[ 4 ] = new Car(5,"Mahindra Scorpio","SUV",8,16.36f,"Good",180,false);
		arr[ 5 ] = new Car(6,"Tata Nexon","SUV",5,17f,"Average",160,false);
		arr[ 6 ] = new Car(7,"Ford EcoSport","SUV",5,15.9f,"Good",190,false);
		arr[ 7 ] = new Car(8,"Volkswagen Vento","Sedan",5,17.69f,"Best",140,false);
		arr[ 8 ] = new Car(9,"Maruti Ertiga","MPV",7,19.01f,"Good",200,false);
		arr[ 9 ] = new Car(10,"Renault Kwid","Hatchback",5,25.17f,"Average",100,false);
		return arr;
	}
	private static Customer[] getValues()
	{
		Customer[] custArr = new Customer[ 10 ];
		custArr[ 0 ] = new Customer("Rohan Kegade","rohan@gmail.com",1234510,10);
		custArr[ 1 ] = new Customer("Kalyani Ikhar","kalyani@gmail.com",5432120,10);
		return custArr;
	}
	
	private static Scanner sc = new Scanner(System.in);
	
	//Take input from user to alter rate of car rent
		private static int acceptNewRate(int rate) {
			System.out.print("Enter New Rate	:	");
			return sc.nextInt();
		}
		public static void acceptRecord(Customer customer) 
		{
			System.out.println("Enter Your Details");
			System.out.print("Name	:	");
			sc.nextLine();
			customer.setCustomerName(sc.nextLine());
			System.out.print("Email ID	:	");
			customer.setEmialId(sc.nextLine());
			System.out.print("Contact No.	:	");
			customer.setContactNo(sc.nextInt());
			System.out.print("Duration(Hours) for which you want to rent car	:");
			customer.setHours(sc.nextInt());
			
		}	
		
		private static int acceptRecord(int i) 
		{
			System.out.print("Enter Car ID  :  ");
			return i = sc.nextInt();
		}
		
		private static void printRecord(Boolean bookingStatus) 
		{
			if(bookingStatus)
				System.out.println("Congratulation! Booking is successfull,Kindly generate your bill!");
			else
				System.out.println("Booking Unsucessfull!!");
		}
		
		private static void acceptRecord(Car car) 
		{
			System.out.println("Enter Car Details");
			System.out.print("Model	:	");
			sc.nextLine();
			car.setCarModel(sc.nextLine());
			System.out.print("Type	:	");
			car.setCarType(sc.nextLine());
			System.out.print("Seating Capacity	:	");
			car.setNoOfSeats(sc.nextInt());
			System.out.print("Mileage	:	");
			car.setMileage(sc.nextFloat());
			System.out.print("Condition	:	");
			sc.nextLine();
			car.setCondition(sc.nextLine());
			System.out.print("Rent Per Hour	:	");
			car.setRentPerHour(sc.nextInt());
			
		}
		
		private static String acceptRecord() 
		{
			System.out.print("Enter Your Email : ");
			sc.nextLine();
			String str = sc.nextLine();	
			return str;
		}
		
		private static String acceptCondition(String str)
		{
			System.out.println("Enter car condition ");
			sc.nextLine();
			
			return sc.next();
		}
		
		//User Menu
		public static int menuList()
	   {
			System.out.println("        ** WELCOME TO CAR RENTAL SYSTEM ** ");
			System.out.println("1. I am a Customer");
			System.out.println("2.I am an Employee");
			System.out.println("3. I am an Manager");
			System.out.println("0.Exit");
			System.out.print("Enter choice	:	");
			return sc.nextInt();
		}
		
		//Customer Menu
		private static int viewCustomerMenu() {
			System.out.println("0.Exit");
			System.out.println("1.View Available Cars");
			System.out.println("2.Rent a Car");
			System.out.println("3.Generate Bill");
			System.out.println("4.Return car");
			System.out.print("Enter choice	:	");
			return sc.nextInt();
		}
		
		//Employee Menu
		private static int viewEmployeeMenu() {
			System.out.println("0.Exit");
			System.out.println("1.View Available Cars");
			System.out.println("2.Add New Car");
			System.out.println("3.Remove Car");
			System.out.print("Enter choice	:	");
			return sc.nextInt();
		}
		
		//Manager Menu
		private static int viewManagerMenu() {
			System.out.println("0.Exit");
			System.out.println("1.View Available Cars");
			System.out.println("2.View Customer Details");
			System.out.println("3.Generate Report");
			System.out.println("4.Modify Rate");
			System.out.print("Enter choice	:	");
			return sc.nextInt();
		}
		
		public static void main(String[] args) {
			int choice;
			int[] i = new int[1];
			Test test = new Test();
			Car[] keys =Program.getKeys();
			Customer[] values = Program.getValues();
			test.addEntries(keys, values);
			try {
				while((choice = menuList()) != 0 ){
					switch(choice) {
					case 1:
						while((choice = Program.viewCustomerMenu()) != 0 ) {
							switch(choice) {
							case 1:
								test.displayCars();			
								break;
							case 2:
								int carId = Program.acceptRecord(i[0]);
								System.out.println(carId);
								Boolean bookingStatus = test.bookCar(carId);
								Program.printRecord(bookingStatus);
								break;
							case 3:
								String email = Program.acceptRecord();
								if(!test.generateBill(email))	
									System.out.println("User Not Found!!!");
								break;
							case 4:
								email = Program.acceptRecord();
								if(!test.returnCar(email))
									System.out.println("User Not Found!!");
								break;
							default:
								System.out.println("Enter Valid Input!");
							}
						}
						break;
					case 2:
						while((choice = Program.viewEmployeeMenu()) != 0 ) {
							switch(choice) {
							case 1:
								test.displayCars();
								break;
							case 2:
								Car car = new Car();
								Program.acceptRecord(car);
								test.addCar(car);
								break;
							case 3:
								int carId = Program.acceptRecord(i[0]);
								Car key = test.getCarKey(carId);
								if(key!=null)
									test.removeCar(key);
								break;
							case 4:
								 carId = Program.acceptRecord(i[0]);
								if(test.isCarAdded(carId)) {
									String str= null;
									String condition = Program.acceptCondition(str);
									test.modifyCondition(carId,condition);
								}
								else
									System.out.println("Car not Found!!");
								break;
							
							default:
								System.out.println("Enter Valid Input!");
							}
						}				
						break;
					case 3:
						while((choice = Program.viewManagerMenu()) != 0 ) {
							switch(choice) {
							case 1:
								test.printEntries( );
								break;
							case 2:
								test.displayCustomers();
								break;
							case 3:
								test.generateReport();
								break;
							case 4:
								int carId = Program.acceptRecord(i[0]); 
								if(test.isCarAdded(carId)) {
									int Rate=0;
									int rate = Program.acceptNewRate(Rate);
									test.modifyRate(carId,rate);
								}
								else
									System.out.println("Car not Found!!");
								break;
							default:
								System.out.println("Enter Valid Input!");
							}
						}
						break;
					default:
						System.out.println("Enter Valid Input!");
					}
				}
			} catch (Exception e) 
			{
				System.out.println("Invalid Input!!");
			}
			finally 
			{
				sc.close();
			}
			System.out.println("Thank You for using our services!!!");
		}
		
				
	
}
