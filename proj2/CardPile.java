/**
 * This class represents cards in the pile of a single player.
 * @author Aaiz Ahmed <aaiza2@umbc.edu>
 * @version Oct 4, 2013
 * @project CMSC 202 - Fall 2013 - Project #2
 * @section 06
 */
package proj2;
import java.util.ArrayList;

public class CardPile {

	private ArrayList<Card> pile;	

	/**
	 * Constructor for CardPile class. It instantiates the ArrayList of type Cards.
	 */
	public CardPile ()	{

		pile = new ArrayList <Card>(); 

	}

/**
 * This method adds a card to a position in card pile.
 * @param i index where card needs to be added.
 * @param c card to be added.
 */
	public void addToPile(int i, Card c) {

		pile.add(i, c);
	}

/**
 * This method returns a card from pile. 
 * @param i
 * @return card from pile.
 */
	public Card getFromPile (int i) {

		return pile.get(i );
	}
		

}
