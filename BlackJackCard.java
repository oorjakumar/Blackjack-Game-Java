public class BlackJackCard extends Card //BlackJackCard class is an extension of Card class
{
  	public BlackJackCard() //constructor calls the default constructor of the parent (Card) class
	{
		super();
	}
	public BlackJackCard(int f, String s) //constructor calls the constructor of the parent (Card) class and gives f and s
	{
		super(f, s);
	}
  	public int getValue()
  	{
		int value = super.getValue(); //setting value equal to value in the parent (or Card) class
		int blackJackValue = 0;
		if (value == 1) //if value is equal to 1, the blackJackValue is 11 (ace)
		{
			blackJackValue = 11;
		}
		if (value >= 11) //if value is 11 or more, the blackJackValue is 10 (jack, king, queen)
		{
			blackJackValue = 10;
		}
		if (2 <= value && value <= 10) //if value is between 2 and 10, the blackJackValue is equal to its value
		{
			blackJackValue = value;
		}
		return blackJackValue; //returns the blackJackValue
  	}
}
