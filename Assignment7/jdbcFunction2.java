import java.sql.* ;

import java.io.* ;
import java.util.Random ;
import java.util.Scanner ;

public class jdbcFunction2 {
  public static void main(String[] args) {

    int emp_id, age;
    String name, gender, hireDate;

    Connection conn = null ;
    Scanner user_input = new Scanner(System.in) ;

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

      System.out.println("Enter (Emp_id, Name, Gender, Age, HireDate) of an Employee you wish to enter: ") ;
      emp_id = user_input.nextInt() ;
      name = user_input.next() ;
      gender = user_input.next();
      age = user_input.nextInt() ;
      hireDate = user_input.next() ;
      System.out.println( "You entered: " + emp_id + " " + name + " " + gender + " " + age + " " + hireDate) ;

      String valueString ;

      stmt = conn.createStatement() ;

  	  valueString = "insert into Employee values(" ;
  	  valueString += "'" + Integer.toString(emp_id) + "'" ;
  	  valueString += ", '" + name + "'" ;
      valueString += ", '" + gender + "'" ;
  	  valueString += ", '" + Integer.toString(age) + "'" ;
  	  valueString += ", '" + hireDate + "'" ;
  	  valueString += ");" ;
  	  
  	  System.out.println( "About to execute: " + valueString ) ;
  	  stmt.executeUpdate( valueString ) ;

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