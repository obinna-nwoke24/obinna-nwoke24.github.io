package Project1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckoutSystemTest {
	CheckoutSystem system;

	@BeforeEach
	void setUp() throws Exception {
		system = new CheckoutSystem(LocalDate.now());
	}

	@Test
	void testgetCurrentDate() {
		String date = system.getCurrentDate().toString();
		//no failures because the expected date is today's date and we got today's date
		assertEquals(LocalDate.now().toString(), date);
	}
	@Test
	void testlistBooksForUser() {
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		String name = "Jason";
		system.checkout(new Book("Book 1", "001"), name);
		String list = system.listBooksForUser(name);
		
		/*
		 * no failures because since a user with the name Jason is not in the system
		 * the expected String for list is "This user is not in our system"
		 */
		assertEquals("This user is not in our system", list);
		
		system.createUser(name);
		system.checkout(new Book("Book 2", "002"), name);
		String list2 = system.listBooksForUser(name);
		String expected = "Books checked out for Jason: 1" + "\n" + "Book 2" + "\n" + "002" + "\n" +
				"Due on " + LocalDate.now().plusDays(14).format(format) + "\n";
		assertEquals(expected, list2);
	}
	@Test
	void testReturnBook() {
		Book book = new Book("Random Name", "123");

		//returns false because there is no user named Jason, so it is impossible to return a book
		String userName = "Jason";
		Boolean False = system.returnBook(book.getCallNum(), userName);
		assertEquals(false, False);
		
		/*
		 * returns true because there is a user named Jason, and a book with
		 * the specified call number was already checked out
		 * So it is possible to return it
		 */
		system.createUser(userName);
		system.checkout(book, userName);
		Boolean True = system.returnBook(book.getCallNum(), userName);
		assertEquals(true, True);
	}

	@Test
	void testCheckout() {
		Book book = new Book("Random Name", "123");
		
		// returns false because there was no User with the name Jason that was added, so there cannot be a book checked out
		String userName = "Jason";
		Boolean False = system.checkout(book, userName);
		assertEquals(false, False);
		
		// returns true because there is a User with the name Jason already added, so the book can be checked out
		system.createUser(userName);
		Boolean True = system.checkout(book, userName);
		assertEquals(true, True);

	}

	@Test
	void testCreateUser() {
		// returns true because there is no user with the name Jason, it then creates the user
		String userName = "Jason";
		Boolean True = system.createUser(userName);
		assertEquals(true, True);
		
		
		// returns false because "Jason" was already created 
		Boolean False = system.createUser(userName); 
		assertEquals(false, False);

	}

}
