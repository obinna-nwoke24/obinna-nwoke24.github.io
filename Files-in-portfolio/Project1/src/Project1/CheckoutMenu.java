package Project1;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * CheckoutMenu handles all details of user interaction It displays a menu and
 * reads the user command input. It also handles all interaction with the user
 * when input is needed to handle a command, such as entering the user name or
 * entering book information
 * 
 * @author Bonnie MacKellar
 *
 */
public class CheckoutMenu {
	private Scanner in;
	// private String currentUser = null;
	private CheckoutSystem system = null;
	private LocalDate currentDate;

	/**
	 * Constructs an CheckoutMenu object.
	 */
	public CheckoutMenu(LocalDate currentDate) {
		in = new Scanner(System.in);

		this.currentDate = currentDate;
	}

	/**
	 * Runs the system. This method kicks off the menu, and determines what to
	 * do based on user command
	 * 
	 * @param system the Checkout System
	 */
	public void run(CheckoutSystem sys) {
		system = sys;
		System.out.println("Welcome to the Very Nice Checkout System");
		DateTimeFormatter format = DateTimeFormatter.ofPattern("LL/dd/yyyy");
		String dateStr = currentDate.format(format);
		System.out.println("Today's date is " + dateStr);
		String command = readCommand();
		while (!command.equals("Q")) {
			if (command.contentEquals("U")) {
				createUser();
			}

			if (command.equals("C")) {
				checkout();
			}

			if (command.equals("R")) {
				returnBook();
			}

			if (command.equals("L")) {
				listBooksOut();
			}

			command = readCommand();
		}
		System.out.println("Bye!");
	}

	// these are private command handlers

	private void createUser() {
		String userName = getUserName();
		Boolean  retVal= system.createUser(userName);
		if (retVal) {
			System.out.println("User " + userName + " was added to the system");
		}
		else {
			System.out.println("User " + userName+ " is already in the system");
		}
		
	}

	private void listBooksOut() {
		String userName = getUserName();
		String list = system.listBooksForUser(userName);
		System.out.println(list);
	}

	private void returnBook() {
		String userName = getUserName();
		String callNum = getCallNumber();
		Boolean returned = system.returnBook(callNum, userName);
		if (!returned)
			System.out.println("There was an error returning the book");
		else
			System.out.println("Book was returned");
	}

	private String getCallNumber() {
		System.out.println("Enter the call number");
		String callNumber = in.nextLine();
		return callNumber;
	}

	private void checkout() {
		String userName = getUserName();
		Book book = getBookInfo();
		if (system.checkout(book, userName)) {
		    System.out.println("The book was checked out");
		}
		else {
			System.out.println("The user is not in the system, book not checkedout");
		}
	}

	private String getUserName() {
		System.out.println("Enter the user name");
		String userName = in.nextLine();
		return userName;
	}

	private Book getBookInfo() {
		System.out.println("Enter the book title");
		String title = in.nextLine();

		String cnum = getCallNumber();
		Book book = new Book(title, cnum);
		return book;
	}

	private String readCommand() {
		System.out.println("Please enter a command");
		System.out.println("U: create a user");
		System.out.println("C: check out a book");
		System.out.println("R: return a book");
		System.out.println("L: list the books checked out by a user");
		System.out.println("Q: quit");
		System.out.println(">>>>>>");
		String command = in.nextLine().toUpperCase();
		return command;
	}

}