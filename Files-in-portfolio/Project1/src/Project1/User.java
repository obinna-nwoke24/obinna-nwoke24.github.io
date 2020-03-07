package Project1;

/**
 * User is a class that we will use to in the library system.
 * Each user will have a set of books that they can checkout and return
 * @author jason nwoke
 *
 */
public class User
{
	private String userName;
	UserCheckoutList ucl;
	private int bkcnt;
	
	/**
	 * Creates a user with no username and give it a checkout list
	 */
	public User()
	{
		userName = null;
		ucl = new UserCheckoutList();
	}
	/**
	 * Creates a user with a set username and gives them a checkout list
	 * @param userName
	 */
	public User(String userName)
	{
		this.userName = userName;
		ucl = new UserCheckoutList();
	}
	/**
	 * 
	 * @return Returns the username of the user
	 */
	public String getUserName()
	{
		return userName;
	}
	/**
	 * Sets the username for the user
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	/**
	 * For this user, it adds a book to their checkout list
	 * @param book
	 */
	public void addBookToList(Book book)
	{
		ucl.addBookToList(book);
	}
	/**
	 * 
	 * @return Returns each book's description that is in the user's checkout list
	 */
	public String listBooks()
	{
		String books = "";
		for (int i = 0; i < ucl.size(); i++)
		{
			books += ucl.get(i).toString();
			books += "\n";
		}
		return books;
	}
	/**
	 * 
	 * @return Returns how many books are in the user's checkout list
	 */
	public int bookCount()
	{
		bkcnt = ucl.size();
		return bkcnt;
	}
	/**
	 * Removes a book from the list with the given the call number
	 * @param callNum
	 */
	public void removeBookFromList(String callNum)
	{
		ucl.removeBookFromList(callNum);
		
	}
}
