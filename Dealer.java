/**
 * Dealer.java  3/27/2026
 *
 * @author - Oorja Kumar
 * @author - Period 7
 * @author - Id 932560
 *
 * @author - I received help from ...
 *
*/
public class Dealer extends Player //Dealer class is an extension of the Player class
{
	private Deck deck; //instance variable Deck
	public Dealer()
	{
		super(); //calling the default constructor of the Player / parent class
		deck = new Deck(); //instantiating instance variable
	}
	public void shuffle()
	{
		deck.shuffle(); //using the Deck class's shuffle method to shuffle deck
	}
	public Card deal()
	{
		return deck.nextCard(); //returning the return value of the nextCard Deck method
	}
	public int numCardsLeftInDeck()
	{
		return deck.numCardsLeft(); //returning the return value of the numCardsLeft Deck method
	}
	public boolean hit()
	{
		boolean canHit = false;
		if (getHandValue() < 21) //if the hand value is less than 21, canHit is true
		{
			canHit = true;
			addCardToHand(deck.nextCard()); //adding nextCard to hand
		}
		return canHit;
    }
}