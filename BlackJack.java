import java.util.Scanner;
import java.util.ArrayList;
public class BlackJack
{
	private ArrayList<Player> players;
	public BlackJack()
	{
		players = new ArrayList<Player>();
	}
	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		String choice = "";
		String output = "";
		ArrayList<Integer> playerWins = new ArrayList<Integer>();
		int dealerTotal = 0;
		int playerTotal = 0;
		int numPlayers = 0;
		String response = "y"; //setting response to y
		System.out.print("How many players (including the dealer)? ");
		numPlayers = keyboard.nextInt();
		for (int i = 0; i < numPlayers; i++)
		{
			if (i == 0)
			{
				players.add(new Dealer());
				playerWins.add(0);
			}
			else
			{
				players.add(new Player());
				playerWins.add(0);
			}
		}
		do //do while loop runs while choice is y or Y
		{
			Dealer dealer = (Dealer) players.get(0);
			dealer.shuffle(); //shuffling the deck before playing
			dealer.resetHand();
			for (int i = 1; i < players.size(); i++)
			{
				Player player = players.get(i);
				player.resetHand(); //resetting the dealer and player's hands
				player.addCardToHand(dealer.deal()); //dealing cards and adding to player and dealer's hands
				player.addCardToHand(dealer.deal());
			}
			dealer.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			for (int i = 1; i < players.size(); i++)
			{
				Player player = players.get(i);
				System.out.print("\nPlayer " + i + " Current hand " + player.cards()); //calling the cards method and printing player's hand
				System.out.println(player.getHandValue()); //printing value of player's hand
				response = "y";
				while (player.hit() && (response.equals("y") || response.equals("Y"))) //while player can hit and response is yes, while loop runs
				{
					System.out.print("\nPlayer " + i + " Do you want to hit? [Y/N]"); //asking user if they want to hit
					response = keyboard.next(); //setting response to whatever the user inputted
					if (response.equals("y") || response.equals("Y")) //if input was yes, add a card to the dealers hand
					{
						player.addCardToHand(dealer.deal());
					}
					System.out.println(printPlayer(i)); //call printPlayer method, give i as the index & print
				}
			}
			response = "y";
			while (dealer.hit())
			{
				dealer.hit();
			}
			System.out.println(printPlayer(0)); //call printDealer method & print
			output = "\n";
			System.out.println("\n-----------------------------\nALL PLAYERS' FINAL CARDS:");
			for (int i = 0; i < players.size(); i++)
			{
				System.out.println(printPlayer(i));
			}
			dealerTotal = dealer.getHandValue();
			for (int i = 1; i < players.size(); i++)
			{
				Player player = players.get(i);
				playerTotal = player.getHandValue();
				if (playerTotal > 21 && dealerTotal <= 21) //if player goes over 21 but dealer doesnt, dealer wins
				{
					output = output + "Dealer wins - Player " + i + " busted!\n";
					playerWins.set(0, playerWins.get(0) + 1); //incrementing dealerWins
				}
				else if (playerTotal <= 21 && dealerTotal > 21) //if dealer goes over 21 but player doesnt, player wins
				{
					output = output + "Player " + i + " wins - Dealer busted!\n";
					playerWins.set(i, playerWins.get(i) + 1); //incrementing playerWins
				}
				else if (playerTotal > 21 && dealerTotal > 21) //if both dealer and player go over 21, both bust
				{
					output = output + "Both player " + i + " and dealer bust!\n";
					playerWins.set(0, playerWins.get(0) + 1); //incrementing dealerWins
				}
				else if (playerTotal < dealerTotal) //if dealer has a bigger total than player, dealer has bigger hand value
				{
					output = output + "Dealer has bigger hand value than player " + i + "!\n";
					playerWins.set(0, playerWins.get(0) + 1); //incrementing dealerWins
				}
				else
				{
					output = output + "Player " + i + " has bigger hand value!\n";
					playerWins.set(i, playerWins.get(i) + 1); //incrementing playerWins
				}
			}
			System.out.println(output + "\n");
			System.out.println("Dealer has won " + playerWins.get(0) + " times");
			for (int i = 1; i < players.size(); i++)
			{
				System.out.println("Player " + i + " has won " + playerWins.get(i) + " times");
			}
			System.out.print("Do you want to play again? [Y, y, N, n] :: "); //asking user if they want to play again
			choice = keyboard.next(); //setting choice equal to whatever the user inputted
			if (choice.equals("y") || choice.equals("Y"))
			{
				dealer.shuffle(); //shuffling deck
			}
		} while(choice.equals("y") || choice.equals("Y"));
	}
	public String printPlayer(int playerIndex) //printPlayer method prints out the playerTotal, handSize, and number of cards for the player
	{
		Player player = players.get(playerIndex);
		int playerTotal = player.getHandValue();
		String output;
		if (playerIndex == 0)
			output = "\nDEALER\n";
		else
			output = "\nPLAYER " + playerIndex + " \n";
		output = output + "Hand Value :: " + playerTotal + "\n";
		output = output + "Hand Size :: " + player.getHandSize() + "\n";
		output = output + "Cards in hand :: " + player.cards() + playerTotal;
		return output;
	}
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack(); //instantiating new object of BlackJack class
		game.playGame(); //calling playGame method
	}
}
