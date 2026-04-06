import java.util.ArrayList;
import java.util.Collections;
public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;
	public static final String [] SUITS = {"CLUBS", "SPADES", "DIAMONDS", "HEARTS"};
	private int topCardIndex; //instance variables for topCardIndex and stackOfCards
	private ArrayList<Card> stackOfCards;
	public Deck() //constructor
	{
		topCardIndex = 	NUMCARDS - 1; //sets topCardIndex to 1 less than the total number of cards (52 - 1 = 51)
		stackOfCards = new ArrayList<Card>(); //setting StackOfCards equal to empty values
		for (String suit : SUITS) //looping through all strings in the SUITS array
		{
			for (int i = 1; i <= NUMFACES; i++) //for each suit, loop through the faces
			{
				stackOfCards.add(new BlackJackCard(i, suit)); //adding a new card with that specific suit and face onto the stackOfCards
			}
		}
	}
	public void setTopCardIndex(int index)
	{
		topCardIndex = index; //setting topCardIndex equal to index
	}
	public void setStackOfCards(ArrayList<Card> stack)
	{
		stackOfCards = stack; //setting stackOfCards equal to stack
	}
   	public void shuffle()
	{
		Collections.shuffle(stackOfCards); //using the shuffle of the Collections class to shuffle stackOfCards
		topCardIndex = stackOfCards.size() - 1; //setting topCardIndex depending on the size of the ArrayList
	}
	public int getTopCardIndex()
	{
		return topCardIndex; //returning topCardIndex for getTopCardIndex
	}
	public ArrayList<Card> getStackOfCards()
	{
		return stackOfCards; //returning stackOfCards for getStackOfCards
	}
	public int size()
	{
		return stackOfCards.size(); //returning size of stackOfCards
	}
	public int numCardsLeft()
	{
		return topCardIndex + 1; //adding 1 to the topCardIndex and returning the number of cards left
	}
	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--); //returning the card at the topCardIndex
	}
	public String toString() //formatting toString
	{
    	String output = "";
    	for (Card card : stackOfCards)
		{
        	output = output + card + "\n";
    	}
    	output = output + "topCardIndex = " + topCardIndex;
    	return output;
	}
}
