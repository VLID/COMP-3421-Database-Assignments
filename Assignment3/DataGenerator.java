import java.io.* ;
import java.util.Random ;
import java.net.*;

public class DataGenerator {
	public static void main(String[] args) {

	Random generator = new Random() ;
	int Customer = 3000 ;
	int Employee = 1000 ;
	int Inventory = 20000 ;
	int Orders = 5000;
	int OrderLine = 20000;


	try {
		String tuple ;				// a tuple/record of attributes
		String a1, a2, a3, a4, a5;     // attributes 1 .. 5
		File file = null ;
		FileWriter fw = null ;
		BufferedWriter bw = null ;


	// create the Customer relation

		file = new File("./data_Customer") ;
		fw = new FileWriter(file) ;
		bw = new BufferedWriter(fw) ;

		for (int i = 1 ; i <= Customer ; i++) {
			// Cus_id
	  		a1 = Integer.toString(i) ;
			
			// Name
	  		a2 = "Vince" + Integer.toString(i) ;
	
			tuple = a1 + "," + a2 + "\n";

			bw.write(tuple) ;
		}
		bw.close() ;


	// create the Employee relation

		file = new File("./data_Employee") ;
		fw = new FileWriter(file) ;
		bw = new BufferedWriter(fw) ;

		for (int i = 1 ; i <= Employee ; i++) {
			// Emp_id
	  		a1 = Integer.toString(i) ;
	
			// Name
			a2 = "Christ" + Integer.toString(i) ;
			
			// Gender
			if (generator.nextInt(2) == 1){
				a3 = "M" ;
			}else{
				a3 = "F" ;
			}
			
			// Age
			a4 = Integer.toString(generator.nextInt(32) + 18);
			
			// HireDate
			a5 = Integer.toString(1990 + generator.nextInt(25)) + "-" + Integer.toString(generator.nextInt(12)+1) + 
			       "-" + Integer.toString(generator.nextInt(28)+1) ;
			tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "," + a5 + "\n";

			bw.write(tuple) ;
		}
		bw.close() ;


	// create the Inventory relation

		file = new File("./data_Inventory") ;
		fw = new FileWriter(file) ;
		bw = new BufferedWriter(fw) ;

		for (int i = 1 ; i <= Inventory ; i++) {
			// Invent_id
	  		a1 = Integer.toString(i) ;

			// Country_id
	  		a2 = Integer.toString( generator.nextInt(10) + 1) ;

			// InventName
	  		a3 = "Toy" + Integer.toString(i);
			
			tuple = a1 + "," + a2 + "," + a3 + "\n";

			bw.write(tuple) ;
		}
		bw.close() ;
		
		
	// create the Orders relation
	
		file = new File("./data_Orders") ;
		fw = new FileWriter(file) ;
		bw = new BufferedWriter(fw) ;

		for (int i = 1 ; i <= Orders ; i++) {
			// Order_id
			a1 = Integer.toString(i);
			
			// Cus_id
			a2 = Integer.toString( generator.nextInt(Customer) + 1) ;
			
			// Emp_id
			a3 = Integer.toString( generator.nextInt(Employee) + 1) ;
			
			//OrderDate
			a4 = Integer.toString(generator.nextInt(3) + 2012) + "-" + Integer.toString(generator.nextInt(12)+1) + 
			       "-" + Integer.toString(generator.nextInt(28)+1) ;
			
			tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "\n";
			
			bw.write(tuple) ;
		}
		bw.close() ;
		
	// create the OrderLine relation
		
		file = new File("./data_OrderLine") ;
		fw = new FileWriter(file) ;
		bw = new BufferedWriter(fw) ;

		for (int i = 1 ; i <= OrderLine ; i++) {
			// Order_id
			a1 = Integer.toString( generator.nextInt(Orders) + 1) ;
			
			// Invent_id
			a2 = Integer.toString(generator.nextInt(Inventory) + 1);
			
			// Quantity
			a3 = Integer.toString(generator.nextInt(20) + 1) ;
			  
			// SellingPrice
			a4 = Integer.toString(generator.nextInt(60) + 5);
			
			tuple = a1 + "," + a2 + "," + a3 + "," + a4 + "\n";
			
			bw.write(tuple) ;
		}
		bw.close() ;
	}
	catch (IOException e) {
		e.printStackTrace() ;
	}
	}
}