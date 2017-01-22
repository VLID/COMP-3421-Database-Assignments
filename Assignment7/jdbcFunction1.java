import java.sql.* ;

import java.io.* ;
import java.util.Random ;
import java.util.Scanner ;

public class jdbcFunction1 {
  public static void main(String[] args) {

	int old_emp_id, new_emp_id;

	Connection conn = null ;
	Scanner user_input = new Scanner(System.in);

	try {

		conn = DriverManager.getConnection("jdbc:mysql://localhost/ToySale?" + 
				"user=lcocox&password=ll" ) ;

	}
	catch (SQLException ex ) {
	  System.out.println("SQLException: " + ex.getMessage()) ;
	  System.out.println("SQLState: " + ex.getSQLState()) ;
	  System.out.println("VendorError: " + ex.getErrorCode()) ;
	}

	Statement stmt = null ;

	try {

	  System.out.println("What's the new employee's id?");
	  new_emp_id = user_input.nextInt();
	  System.out.println("Which the old employee's id you want to change in an order?");
	  old_emp_id = user_input.nextInt();
	  System.out.println("You entered the New Employee Id is " + new_emp_id + ", and the Old Employee ID is " + old_emp_id + ".");

	  String valueString;

	  stmt = conn.createStatement() ;

	  valueString = "update Orders set Emp_id = ";
	  valueString += Integer.toString(new_emp_id);
	  valueString += " where Emp_id = ";
	  valueString += Integer.toString(old_emp_id);
	  valueString += ";";

	  System.out.println("About to execute: " + valueString);

	  stmt.executeUpdate( valueString );
	  
	  stmt.close() ;
	  conn.close() ;

	}

	catch (SQLException ex ) {
	  System.out.println("SQLException: " + ex.getMessage()) ;
	  System.out.println("SQLState: " + ex.getSQLState()) ;
	  System.out.println("VendorError: " + ex.getErrorCode()) ;
	}
  }
}
