import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author jason nwoke
 *
 */
public class GameList
{
	private ArrayList<Game> myGames;
	private Scanner scan;
	
	
	/**
	 * Default Game List: 4 games on the list
	 */
	public GameList()
	{
		myGames = new ArrayList<Game>();
		Game game = new Game("Grand Theft Auto", "M");
		myGames.add(game);
		game = new Game("NBA 2k20", "E");
		myGames.add(game);
		game = new Game("WWE 2k20", "T");
		myGames.add(game);
		game = new Game("Apex Legends", "T");
		myGames.add(game);
	}
	/**
	 * Adds a game to the list
	 * @param aGame
	 */
	public void addGame(Game aGame)
	{
		myGames.add(aGame);
		System.out.println("'" + aGame.getTitle() + "' ----was successfully added----  '" + "Rated " + aGame.getRating() + "'");
	}
	/**
	 * Removes a game from the list
	 * @param title
	 */
	public void removeGame(String title)
	{
		myGames.remove(searchGame(title));
		System.out.println("'" + title + "' ----was successfully removed----");
	}
	/**
	 * Asks which game to remove
	 * @return the title of the game to remove
	 */
	public String removeGameQuestion()
	{
		scan = new Scanner(System.in);
		System.out.print("What game do you want to remove?: ");
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Options available for the list
	 */
	public void loopQuestion()
	{
		System.out.println("What do you want to do:");
		System.out.println("0_ End the terminal");
		System.out.println("1_ View the list");
		System.out.println("2_ Add a game");
		System.out.println("3_ Remove a game");
		System.out.println("4_ Change a game's rating");
		System.out.println("5_ Search for a game");
		System.out.println("6_ List count");
		System.out.print("Choice: ");
	}
	/**
	 * Asks what the title of the game is
	 * @return the title of the game
	 */
	public String createGameTitleQuestion()
	{
		scan = new Scanner(System.in);
		System.out.print("What is the title of the game?: ");
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Asks what the letter rating of the game is
	 * @return the letter rating of the game
	 */
	public String createGameRatingQuestion()
	{
		scan = new Scanner(System.in);
		System.out.print("What is the letter rating of the game?: ");
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Asks the game title question and the game rating question.
	 * Then creates a new game based on the answers to the questions
	 * @return the new Game created
	 */
	public Game createGame()
	{
		String gametitle = createGameTitleQuestion();
		String gamerating = createGameRatingQuestion();
		
		Game game = new Game(gametitle, gamerating);
		return game;
	}
	/**
	 * Changes the rating of the game based on input
	 * @param title
	 * @param newRating
	 */
	public void changeGameRating(String title, String newRating)
	{
		searchGame(title).setRating(newRating);
		System.out.println("'" + searchGame(title).getTitle() + "'" +
				" ----Rating successfully changed to " + newRating.toUpperCase() + " ----");
	}
	/**
	 * Asks the game title that the user wants to change its rating for
	 * @return the title of the game
	 */
	public String titleGameRatingQuestion()
	{
		scan = new Scanner(System.in);
		System.out.print("What game's rating do you want to change?: ");
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Asks the user to input the rating to change the game to
	 * @return the rating to change to
	 */
	public String ratingGameRatingQuestion()
	{
		scan = new Scanner(System.in);
		System.out.print("What is the rating you want to change it to?: ");
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Searches for a Game in the list
	 * @param Game
	 * @return the game if found and null if not
	 */
	private Game searchGame(String Game)
	{
		for (Game game: myGames)
		{
			if (game.getTitle().equals(Game))
			{
				return game;
			}
		}
		return null;
	}
	/**
	 * Will tell the user is the game was found or not
	 * @param Game
	 */
	public void searchForGame(String Game)
	{
		Game foundgame = searchGame(Game);
		if (foundgame == null)
			System.out.println("----'" + Game + "' was not found in the system----");
		else
			System.out.println("----'" + Game + "' was found in the system----");
	}
	/**
	 * Asks for the title for the game so it can search
	 * @return the title of the game
	 */
	public String searchQuestion()
	{
		scan = new Scanner(System.in);
		System.out.print("What game are you searching for (title)?: ");
		String input = scan.nextLine();
		return input;
	}
	/**
	 * Counts each game in the list
	 * @return the size of the list
	 */
	public int GameListSize()
	{
		int count = 0;
		
		for (int i = 0; i < myGames.size(); i++)
		{
			count += 1;
		}
		return count;
	}
	/**
	 * Checks how many ratings for a certain game rating
	 * @param checkRating
	 * @return the number of a single rating
	 */
	public int checkNumRating(String checkRating)
	{
		int count = 0;
		
		for (int i = 0; i < myGames.size(); i++)
		{
			if (myGames.get(i).getRating().equals(checkRating))
			{
				count += 1;
			}
		}
		return count;
	}
	/**
	 * Prints each game in the list
	 */
	public void printGameList()
	{
		for (int i = 0; i < myGames.size(); i++)
		{
			System.out.println(myGames.get(i).toString());
		}
	}
}
