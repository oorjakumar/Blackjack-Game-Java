/**
 * Player.java  3/26/2026
 *
 * @author - Oorja Kumar
 * @author - Period 7
 * @author - Id 932560
 *
 * @author - I received help from ...
 *
*/
import java.util.ArrayList;
public class Player
{
	private ArrayList<Card> hand; //instance variables for ArrayList hand and a winCount
   	private int winCount;
   	public Player() //this constructor sets instance variables to empty values
   	{
   		winCount = 0;
		hand = new ArrayList<Card>();
   	}
   	public Player(int score) //this constructor sets hand to empty values & the winCount to a score
   	{
		winCount = score;
		hand = new ArrayList<Card>();
   	}
   	public void addCardToHand(Card temp)
   	{
   		hand.add(temp); //adding the Card object temp onto the hand ArrayList
   	}
   	public void resetHand( )
   	{
   		hand.clear(); //the resetHand() method clears the hand ArrayList
   	}
   	public  void setWinCount( int numwins )
   	{
		winCount = numwins; //setting winCount to numWins
   	}
   	public int getWinCount()
	{
		return winCount; //getWinCount() method returns winCount
	}
   	public int getHandSize()
   	{
   		return hand.size(); //getHandSize() method returns the size of the hand ArrayList
	}
   	public int getHandValue()
   	{
		int total = 0; //setting total to 0
		int numberOfAces = 0; //int variable for number of aces
		for (Card card : hand) //the for each loop runs for each Card object in the hand ArrayList
		{
			int value = card.getValue(); //setting value equal to the card's value
			total = total + value; //adding that value to total
			if (value == 11) //if that card was an ace, adding 1 to the numberOfAces
			{
				numberOfAces = numberOfAces + 1;
			}
			while (numberOfAces != 0 && total > 21) //if there is an ace and the total is greater than 21, the ace becomes a 1 (so total-10) and removing 1 from ace
			{
				total = total - 10;
				numberOfAces = numberOfAces - 1;
			}
		}
		return total; //returning total
   	}
   	public  boolean  hit()
   	{
      	boolean canHit = false;
	  	int total = getHandValue(); //setting total equal to return value of getHandValue
	  	if (total < 21) //if the total hasn't reached 21 yet, canHit is true. Otherwise, it is false
	  	{
	  		canHit = true;
	  	}
	  	return canHit;
   	}
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	public String cards() //cards method makes an output but without the values for each card
	{
		int count = 0;
		String output = "hand = [";
		for (Card card : hand)
		{
			output = output + card.toStringNoValues();
			if (count != hand.size() - 1)
			{
				output = output + "\n ";
			}
			else
			{
				output = output + "] - ";
			}
			count++;
		}
		return output;
	}
   	public String toString()
   	{
      	String output = "[";
		int index = 0;
		for (Card card : hand) //for each loop will run for each Card object in hand
	  	{
			if (index != getHandSize() - 1) //if it's not the last card, indent at the end
			{
				output = output + card + "\n ";
			}
			else
			{
				output = output + card; //if it is the last card, no indent at the end
			}
			index++;
	  	}
		output = output + "]";
	  	return "hand = " + output + " - " + getHandValue();
   	}
}