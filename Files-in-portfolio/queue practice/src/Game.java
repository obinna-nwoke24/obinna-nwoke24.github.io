/**
 * 
 * @author jason nwoke
 *
 */
public class Game 
{
	private String title;
	private String rating;

	/**
	 * Creates a null Game object
	 */
	public Game()
	{
		
	}
	/**
	 * Creates a Game with a title and a rating
	 * @param title and rating
	 * 
	 */
	public Game(String t, String r)
	{
		title = t;
		rating = r;
	}
	/**
	 * Sets an already made Game to the title and rating of the users choosing
	 * @param title and rating
	 * 
	 */
	public void setGame(String t, String r)
	{
		title = t;
		rating = r;
	}
	/**
	 * Sets the title for an already made Game
	 * @param t
	 */
	public void setTitle(String t)
	{
		title = t;
	}
	/**
	 * Sets the rating for an already made Game
	 * @param r
	 */
	public void setRating(String r)
	{
		rating = r;
	}
	/**
	 * 
	 * @return the title of a game
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * 
	 * @return the rating of a game
	 */
	public String getRating()
	{
		return rating;
	}
	/**
	 * Makes the object available to print to console
	 */
	public String toString()
	{
		String description = "Title: " + getTitle() + "\n" + "Rating: " + getRating() + "\n";
		return description;
	}
}
