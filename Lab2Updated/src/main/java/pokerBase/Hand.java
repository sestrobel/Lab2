package pokerBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Hand {
	private UUID HandID;
	private boolean bScored;
	private HandScore handScore;
	private ArrayList<Card> CardsInHand;
	
	public Hand() {
		//constructor of hand, not done
		this.HandID = UUID.randomUUID();
		bScored = false;
	}


	private ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}

	private void setHandScore(HandScore handScore){
		this.handScore=handScore;
		bScored = true;
	}
	
	public HandScore getHandScore(){
		return handScore;
	}
	
	private void sortHand(ArrayList<Card> hand) {
//		//if the first card is greater than the one following it, needs to be tested 
//		if (hand.get(0).getiCardNbr()>hand.get(1).getiCardNbr()) { 
//			Collections.swap(hand, 0, 1);
//		}
//		if (hand.get(1).getiCardNbr()>hand.get(2).getiCardNbr()) { 
//			Collections.swap(hand, 1, 2);
//		}
//		if (hand.get(0).getiCardNbr()>hand.get(1).getiCardNbr()) { 
//			Collections.swap(hand, 0, 1);
//		}
//		if (hand.get(2).getiCardNbr()>hand.get(3).getiCardNbr()) { 
//			Collections.swap(hand, 2, 3);
//		}		 
//		if (hand.get(1).getiCardNbr()>hand.get(2).getiCardNbr()) { 
//			Collections.swap(hand, 1, 2);
//		}
//		if (hand.get(0).getiCardNbr()>hand.get(1).getiCardNbr()) { 
//			Collections.swap(hand, 0, 1);
//		}
//		if (hand.get(3).getiCardNbr()>hand.get(4).getiCardNbr()) { 
//			Collections.swap(hand, 3, 4);
//		}	
//		if (hand.get(2).getiCardNbr()>hand.get(3).getiCardNbr()) { 
//			Collections.swap(hand, 2, 3);
//		}		 
//		if (hand.get(1).getiCardNbr()>hand.get(2).getiCardNbr()) { 
//			Collections.swap(hand, 1, 2);
//		}
//		if (hand.get(0).getiCardNbr()>hand.get(1).getiCardNbr()) { 
//			Collections.swap(hand, 0, 1);
//		}
		Collections.sort(CardsInHand);
	}
	
	private void EvaluateHand(ArrayList<Card> hand) {
		//how to calculate this? not done
		sortHand(hand);
	}
	
	private static boolean isHandFlush(ArrayList<Card> cards) {

		// TODO Implement this method
		boolean bIsFlush = false;
		return bIsFlush;
	}

	private static boolean isStraight(ArrayList<Card> cards, Card highCard) {
		boolean bIsStraight = false;
		// TODO Implement this method

		return bIsStraight;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {

		boolean isRoyalFlush = false;
		// TODO Implement this method
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		boolean isRoyalFlush = false;
		// TODO Implement this method
		return isRoyalFlush;
	}

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {

		boolean bHandCheck = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			bHandCheck = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return bHandCheck;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {

		boolean isFullHouse = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {
			
			if (h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
					.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
				isFullHouse = true;
				hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(0);
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
				hs.setKickers(kickers);

		}} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
					.get(eCardNo.SecondCard.getCardNo()).geteRank()) {
				isFullHouse = true;
				hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(0);
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
				hs.setKickers(kickers);
		}}

		return isFullHouse;

	}

	public static boolean isHandFlush(Hand h, HandScore hs) {

		boolean bIsFlush = false;
		// TODO Implement this method
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {

		boolean bIsStraight = false;
		// TODO Implement this method
		return bIsStraight;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {

		boolean isThreeOfAKind = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			//???
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			//???
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			//???
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return isThreeOfAKind;
		
		
		
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {

		boolean isTwoPair = false;
		// TODO Implement this method
		return isTwoPair;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean isPair = false;
		// TODO Implement this method
		return isPair;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		// TODO Implement this method
		return true;
	}
}
