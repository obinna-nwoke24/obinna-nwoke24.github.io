package Project1;
import java.util.ArrayList;

/**
 * UserCheckoutList has an arraylist of books that will be assigned to the
 * respective user
 * @author jason nwoke
 *
 */
public class UserCheckoutList
{
	private ArrayList<Book> books;
	
	/**
	 * Creates an empty arraylist of books
	 */
	public UserCheckoutList()
	{
		books = new ArrayList<Book>();
	}
	/**
	 * Adds a book to the list of books
	 * @param book
	 */
	public void addBookToList(Book book)
	{
		book = new Book(book.getTitle(), book.getCallNum());
		books.add(book);
	}
	/**
	 * 
	 * @return Returns the number of books in the arraylist
	 */
	public int size()
	{
		return books.size();
	}
	/**
	 * 
	 * @param index
	 * @return Returns the book at the index specified in the arraylist
	 */
	public Book get(int index)
	{
		Book book = null;
		for (int i = 0; i < books.size(); i++)
		{
			book = books.get(index);
		}
		return book;
	}
	/**
	 * Removes the book from the list given the call number
	 * @param callNum
	 */
	public void removeBookFromList(String callNum)
	{
		for (int i = 0; i < books.size(); i++)
		{
			if (books.get(i).getCallNum().equals(callNum))
			{
				books.remove(books.get(i));
			}
		}
	}
}
