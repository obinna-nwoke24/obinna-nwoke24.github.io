import java.util.Scanner;

public class TestFile 
{
	public static void main (String [] args) throws InterruptedException
	{
		GameList myList = new GameList();
		Scanner scan = new Scanner(System.in);
		int loop = -1;
		
		do
		{
			myList.loopQuestion();
			loop = scan.nextInt();
			
			if (loop == 1)
			{
				System.out.println();
				myList.printGameList();
			}
			else if (loop == 2)
			{
				Game newGame = myList.createGame();
				myList.addGame(newGame);
			}
			else if (loop == 3)
			{
				String inupt = myList.removeGameQuestion();
				myList.removeGame(inupt);
			}
			else if (loop == 4)
			{
				String gt = myList.titleGameRatingQuestion();
				String gr = myList.ratingGameRatingQuestion();
				myList.changeGameRating(gt, gr);
			}
			else if (loop == 5)
			{
				String input = myList.searchQuestion();
				myList.searchForGame(input);
			}
			else if (loop == 6)
			{
				System.out.println("----The list has " + myList.GameListSize() + " games----" + "\n");
			}
			else if (loop == 0)
			{
				break;
			}
			else
				System.out.println("----Invalid option! Please try again!----");
		}
		while (loop != 0);
		
		System.out.print("\n" + "Terminal Stopped");
		scan.close();
		System.out.close();
	}

}
