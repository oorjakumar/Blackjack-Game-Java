public class Card
{
	public static final String [] FACES = {"ZERO", "ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
	private String suit; //instance variables for suit and face
	private int face;
  	public Card() //this constructor sets instance variables to empty values
	{
		suit = " ";
		face = 0;
	}
	public Card(int f, String s) //this constructor sets instance variables to f and s
	{
		suit = s;
		face = f;
	}
	public void setSuit(String s)
	{
		suit = s; //setSuit() sets suit equal to s
	}
	public void setFace(int f)
	{
		face = f; //setFace() sets face equal to f
	}
	public String getSuit()
	{
		return suit; //getSuit() accesses suit
	}
  	public int getValue()
  	{
  		return face; //getValue() accesses the value or the face
  	}
	public boolean equals(Object obj)
	{
		Card other = (Card) obj; //casting obj of the Object class to the Card class (other)
		boolean suitEquals = false; //creating boolean variables for suitEquals and valueEquals
		boolean valueEquals = false;
		if (getSuit().equals(other.getSuit())) //if getSuit and getSuit of other are equal, suitEquals is true
		{
			suitEquals = true;
		}
		if (getValue() == other.getValue()) //if getValue and getValue of other are equal, valueEquals is true
		{
			valueEquals = true;
		}
		return valueEquals && suitEquals; //if both valueEquals and suitEquals are true, equals method will return true. otherwise, false
	}
	public int hashCode() //dummy hashCode method so that checkstyle is happy
	{
    	return 0;
	}
	public String toStringNoValues() //the toStringNoValues method prints out the cards without the values of them
	{
		return FACES[face] + " of " + getSuit();
	}
	public String toString() //toString returns the face at index face on FACES and calls getSuit and getValue
	{
		return FACES[face] + " of " + getSuit() + " | value = " + getValue();
	}
}
