package Project1;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * CheckoutSystem creates the system for the library to add a user, list books for a certain user,
 * checkout a book, and return a book
 * @author jason nwoke
 *
 */
public class CheckoutSystem 
{
	private LocalDate currentdate = LocalDate.now();
	private ArrayList<User> userlist;
	
	/**
	 * Creates a checkout system with today's date and a list of users
	 * @param date
	 */
	public CheckoutSystem(LocalDate date)
	{
		this.currentdate = date;
		userlist = new ArrayList<User>();
	}
	/**
	 * 
	 * @return Returns the current date
	 */
	public LocalDate getCurrentDate()
	{
		return currentdate;
	}
	/**
	 * 
	 * @param userName
	 * @return Returns each book with their description for the specified user
	 */
	public String listBooksForUser(String userName)
	{
		String list = "";
		User aUser = new User(userName);
		for (User user: userlist)
		{
			if (user.getUserName().equals(userName))
			{
				aUser = user;
			}
		}
		if (userlist.contains(aUser) && aUser.bookCount() > 0)
		{
			list+= "Books checked out for " + aUser.getUserName() + ": " + aUser.bookCount() + "\n";
			list+= aUser.listBooks();
		}
		else if (userlist.contains(aUser) && aUser.bookCount() == 0)
		{
			list += "Books checked out for " + aUser.getUserName() + ": " + aUser.bookCount() + "\n";
			list += "There are no books checked out for " + aUser.getUserName();
		}
		else
		{
			list = "This user is not in our system";
		}
		return list;
	}
	/**
	 * Returns a book by call number and removes it from the user's checkout list
	 * @param callNum
	 * @param userName
	 * @return Returns true if there is a user that matches the username in the parameter, and false if otherwise
	 */
	public Boolean returnBook(String callNum, String userName)
	{
		for (User user: userlist)
		{
			if (user.getUserName().equals(userName))
			{
				user.removeBookFromList(callNum);
				return true;
			}
		}
		return false;
	}
	/**
	 * Checks out a book from the library and adds it to the user's checkout list
	 * @param book
	 * @param userName
	 * @return Returns true if there is a user that matches the username in the parameter, and false if otherwise
	 */
	public boolean checkout(Book book, String userName)
	{
		for (User user: userlist)
		{
			if (user.getUserName().equals(userName))
			{
				user.addBookToList(book);
				return true;
			}
		}
		return false;
	}
	/**
	 * Creates a user if there is no user with the specified username
	 * @param userName
	 * @return Returns false if there is a username that matches and it won't add that user. But returns true is there is no
	 * user with the specified name, and will create that user
	 */
	public Boolean createUser(String userName)
	{
		for (User user: userlist)
		{
			if (user.getUserName().equals(userName))
			{
				return false;
			}
		}
		userlist.add(new User(userName));
		return true;
	}
}
