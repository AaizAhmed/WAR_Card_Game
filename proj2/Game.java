/**
 * This class players the game of the war and uses related objects and their methods to do so.
 * @author Aaiz Ahmed <aaiza2@umbc.edu> 
 * @project CMSC 202 - Fall 2013 - Project #2
 * @section 06
 * @created: Oct 4, 2013
 * @modified Dec 21, 2016
 */
package proj2;

public class Game {

	//Declaring all the required variables and classes. 
	private String name1, name2;
	private int pileIndex = 25, p1Value, p2Value, points1, points2, war1, war2, tWars, warPoints = 8;
	private boolean isWar = false;
	private Deck deck;	
	private Player player1, player2;  

	/**
	 * Constructor: for the Game class.
	 * @param p1Name  Name of player1
	 * @param p2Name  Name of player2
	 * @param rngSeed seed for shuffling cards. 
	 */
	public Game (String p1Name, String p2Name, long rngSeed) {

		//Instantiating all the declared variable and classes.
		name1 = p1Name;    name2 = p2Name;

		deck = new Deck();

		//Instantiating 2 players.
		player1 = new Player (p1Name);
		player2 = new Player (p2Name);

		deck.shuffleCard(rngSeed);  

		/* Adding cards to the card pile of both players using "setPile(int, Card)" method of Player class.
		 * This method takes int index and a card as an argument. "getCard(int)" method from Deck class is 
		 * used to get card from shuffled desk 
		 */
		int i = 51, j = 50;
		for (int n = 0; n < 26; n++) {

			player1.setPile(n, deck.getCard(i));
			player2.setPile(n, deck.getCard(j));

			i = i - 2;   j = j - 2;
		}

	}

	/**
	 * This method checks if cards are still in the pile or not.
	 * @return true or false.
	 */
	public boolean gameComplete() {

		if (pileIndex < 0) {

			return true;
		}  

		return false;  
	}

	/**
	 * This method checks which player has thrown the larger card and decides winner or war based on that.
	 */
	private String compareCard () {

		String str = "";

		//getCardFromPile(int) returns a card and the value() returns int value associated with that card.
		p1Value = player1.getCardFromPile(pileIndex).value();
		p2Value = player2.getCardFromPile(pileIndex).value(); 

		if (p1Value > p2Value) {

			if (isWar == true) {
				str += name1 + " wins " + (warPoints + 2) + " cards ";
			}
			else {
				str = name1 + " wins 2 cards ";
			}

			pileIndex--;
			points1 = points1 + 2;  
			isWar = false;
		}
		else {
			if (p2Value > p1Value) {

				if (isWar == true) {
					str += name2 + " wins " + (warPoints + 2) + " cards ";
				}
				else {
					str = name2 + " wins 2 cards ";
				}

				pileIndex--;
				points2 = points2 + 2; 
				isWar = false;
			}
			else {

				if (p1Value == p2Value) {

					str = "WAR!! ";

					pileIndex = pileIndex - 4;

					if (gameComplete() == false) {

						decider();									
					} 
					else {						
						str = "WAR!! \nNOT ENOUGH CARDS LEFT TO FINISH THE WAR!";
					}

					tWars++; 
					isWar = true;
				}
			}
		}

		return str;
	}

	/**	
	 * In case of war this method checks which player has the larger card.
	 */
	public void decider() {		

		p1Value = player1.getCardFromPile(pileIndex).value();
		p2Value = player2.getCardFromPile(pileIndex).value(); 

		if ( p1Value > p2Value ) {
			points1 = points1 + warPoints;
			war1++;
		} 
		else if ( p2Value > p1Value ) {
			points2 = points2 + warPoints;
			war2++;
		} 
		else {	

			//It is WAR again so putting aside 8 more cards to be won.
			//This process will continue until there is a winner or there are no more cards left.
			warPoints = warPoints + 8;
		}

	}


	/**
	 * This method executes a turn and calls appropriate methods to check results of the turn. 
	 * @return names and cards of both players after every turn.
	 */
	public String nextTurn() {

		String str;
		str = name1 + " shows " + player1.getCardFromPile(pileIndex) + "\n" + 
				name2 + " shows " + player2.getCardFromPile(pileIndex) + "\n";

		str += compareCard() + "\n";

		return str;		
	}

	/**
	 * This methods gives results of the game. 
	 * @return result
	 */
	public String gameResult() {

		String result;

		result = "There were " + tWars + " wars\n" + name1 + " won " + points1 + " cards and " + war1 + " war(s)\n";
		result += name2 + " won " + points2 + " cards and " + war2 + " war(s)\n";

		if ( points1 > points2) {
			result += "Winner: " + name1; 
		}
		else {
			if (points2 > points1) {
				result += "Winner: " + name2;
			}
			else {
				if (points1 == points2)
					result += "It is a draw.";		
			}
		}
		return result;
	}


	/*
	 * Main method for unit testing. 	
	 */
	public static void main (String [] args) {

		//Use 1234 for an incomplete WAR
		//Use 7897654 for a draw situation.
		//Use 1 for a situation where 4th card causes WAR again.
		Game war = new Game ( "Aaiz", "John" , 123456);

		while (!war.gameComplete()) {

			System.out.println (war.nextTurn()); 
		}

		System.out.println (war.gameResult());


	}


}
