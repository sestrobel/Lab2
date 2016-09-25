package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();

	public Deck() {
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				deckCards.add(new Card(eSuit, eRank, iCardNbr++));
			}
		}
		Collections.shuffle(deckCards);
	}
	public ArrayList<Card> getDeck() {
		//implement like deck.getDeck()
		return deckCards;
	}
	public Card Draw(){
		//implement like deck.Draw()
		return deckCards.remove(0);
	}
	public int GetDeckSize(){
		//returns length of deck
		//implement like deck.getDeckSize()
		return deckCards.size();
	}
}
