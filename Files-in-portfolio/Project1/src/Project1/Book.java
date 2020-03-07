package Project1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
/**
 * Book creates a basic book that we will use in the library.
 * @author jason nwoke
 *
 */
public class Book 
{
	private String title;
	private String callnum;
	private DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
	private String dueDate = LocalDate.now().plusDays(14).format(format);
	
	/**
	 * Creates a Book object with no title or call number
	 */
	public Book()
	{
		title = null;
		callnum = null;
	}
	/**
	 * Creates a Book object with a title and a call number
	 * @param title
	 * @param callnum
	 */
	public Book(String title, String callnum)
	{
		this.title = title;
		this.callnum = callnum;
	}
	/**
	 * 
	 * @return Returns the title of the book
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * 
	 * @return Returns the call number of the book
	 */
	public String getCallNum()
	{
		return callnum;
	}
	/**
	 * Sets the title of a book
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * Sets the call number of the book
	 * @param callnum
	 */
	public void setCallNum(String callnum)
	{
		this.callnum = callnum;
	}
	/**
	 * Formats the Book to show the Title, Call Number, and return
	 * date on separate lines
	 */
	public String toString()
	{
		String desc = "";
		desc += getTitle() + "\n" + getCallNum() + "\n";
		desc += "Due on " + dueDate;
		return desc;
	}
}
