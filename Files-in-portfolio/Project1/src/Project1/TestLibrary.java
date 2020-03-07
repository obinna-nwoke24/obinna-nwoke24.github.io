package Project1;
/**
 * This starts the library system
 */

import java.io.IOException;
import java.time.LocalDate;

public class TestLibrary {
	public static void main(String[] args)
	         throws IOException
	   { 
		  LocalDate currentDate = LocalDate.now();
	      CheckoutSystem system = new CheckoutSystem(currentDate);
	      CheckoutMenu menu = new CheckoutMenu(currentDate);
	      menu.run(system);
	   }
}