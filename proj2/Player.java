/**
 * This class represents a single player during the game. It shows their name and cards etc.
 * @author Aaiz Ahmed <aaiza2@umbc.edu> 
 * @project CMSC 202 - Fall 2013 - Project #2
 * @section 06
 * @created: Oct 4, 2013
 * @modified Dec 21, 2016
 */
package proj2;

public class Player {

	private String name;
	private CardPile pile;

	/**
	 * Constructor : instantiates a player object. Represents name and pile of the player.
	 * @param  String: name
	 * @param  CardPile: pile of a single player.
	 */
	public Player (String name) {

		this.name = name;
		pile = new CardPile ();
	}

	/**
	 * This method adds a card on a specified position in the card pile of the player.
	 * @param i
	 * @param c
	 */
	public void setPile (int i, Card c){

		pile.addToPile(i, c);
	}

	/**
	 * This method return pile of a player.
	 * @return pile
	 */
	public CardPile getPile () {

		return pile;
	}

	/**
	 * This method allows user to take out any card from a specified index from a pile of cards. 
	 * It uses getFromPile method of CardPile class.
	 * @param i
	 * @return a card from the card pile.
	 */
	public Card getCardFromPile (int i){

		return pile.getFromPile(i);
	}

	/**
	 * Return the name of the player.
	 * @return name
	 */
	public String getName() {

		return name;
	}

}
