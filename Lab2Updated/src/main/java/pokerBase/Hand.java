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
		// constructor of hand
		this.HandID = UUID.randomUUID();
		bScored = false;
	}

	private ArrayList<Card> getCardsInHand() {
		return CardsInHand;
	}

	private void setHandScore(HandScore handScore) {
		this.handScore = handScore;
		bScored = true;
	}

	public HandScore getHandScore() {
		return handScore;
	}

	private void sortHand(ArrayList<Card> hand) {
		Collections.sort(CardsInHand);
	}

	public void EvaluateHand(Hand h) {
		sortHand(h.CardsInHand);
		if (Hand.isHandRoyalFlush(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandStraightFlush(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandFourOfAKind(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandFullHouse(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandFlush(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandStraight(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandThreeOfAKind(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandTwoPair(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandPair(h, h.getHandScore())) {
			return;
		}
		if (Hand.isHandHighCard(h, h.getHandScore())) {
			return;
		}
	}

	private static boolean isHandFlush(Hand h) {

		boolean bIsFlush = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteSuit() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteSuit()
				&& h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteSuit() == h.getCardsInHand()
						.get(eCardNo.ThirdCard.getCardNo()).geteSuit()
				&& h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteSuit() == h.getCardsInHand()
						.get(eCardNo.FourthCard.getCardNo()).geteSuit()
				&& h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteSuit() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteSuit()) {
			bIsFlush = true;
		}
		return bIsFlush;
	}

	private static boolean isStraight(ArrayList<Card> cards, Card highCard) {

		boolean bIsStraight = false;

		if (cards.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr() == 14) {
			if (cards.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == 2
					&& cards.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr() == 3
					&& cards.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr() == 4
					&& cards.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr() == 5) {
				bIsStraight = true;
				highCard = cards.get(eCardNo.FourthCard.getCardNo());
			} else if (cards.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == 10
					&& cards.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr() == 11
					&& cards.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr() == 12
					&& cards.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr() == 13) {
				bIsStraight = true;
				highCard = cards.get(eCardNo.FifthCard.getCardNo());
			}
		} else if (cards.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() + 1 == cards
				.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr()) {
			if (cards.get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr() + 1 == cards
					.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr()) {
				if (cards.get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr() + 1 == cards
						.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr()) {
					if (cards.get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr() + 1 == cards
							.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr()) {
						bIsStraight = true;
						highCard = cards.get(eCardNo.FifthCard.getCardNo());
					}
				}
			}
		}

		return bIsStraight;
	}

	public static boolean isHandRoyalFlush(Hand h, HandScore hs) {

		boolean isRoyalFlush = false;
		if (Hand.isHandFlush(h)) {
			Card highCard = null;
			if (Hand.isStraight(h.getCardsInHand(), highCard)) {
				if (h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr() == eRank.ACE
						.getiRankNbr()) {
					isRoyalFlush = true;
					hs.setHandStrength(eHandStrength.RoyalFlush.getHandStrength());
					hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
					hs.setLoHand(0);
				}
			}
		}
		return isRoyalFlush;
	}

	public static boolean isHandStraightFlush(Hand h, HandScore hs) {
		boolean bIsStraightFlush = false;
		if (Hand.isHandFlush(h)) {
			Card highCard = null;
			if (Hand.isStraight(h.getCardsInHand(), highCard)) {
				bIsStraightFlush = true;
				hs.setHandStrength(eHandStrength.StraightFlush.getHandStrength());
				ArrayList<Card> kickers = new ArrayList<Card>();
				hs.setKickers(kickers);
				hs.setLoHand(0);
				if (h.CardsInHand.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr() == 14
						&& h.CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == 2) {
					hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
				} else {
					hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
				}
			}
		}
		return bIsStraightFlush;
	}

	public static boolean isHandFourOfAKind(Hand h, HandScore hs) {

		boolean isHandFourOfAKind = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isHandFourOfAKind = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			isHandFourOfAKind = true;
			hs.setHandStrength(eHandStrength.FourOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return isHandFourOfAKind;
	}

	public static boolean isHandFullHouse(Hand h, HandScore hs) {

		boolean isFullHouse = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()
				&& h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()
				&& h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.SecondCard.getCardNo()).geteRank()) {
			isFullHouse = true;
			hs.setHandStrength(eHandStrength.FullHouse.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			hs.setKickers(kickers);
		}

		return isFullHouse;

	}

	public static boolean isHandFlush(Hand h, HandScore hs) {

		boolean bIsFlush = false;
		if (Hand.isHandFlush(h)) {
			bIsFlush = true;
			hs.setHandStrength(eHandStrength.Flush.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return bIsFlush;
	}

	public static boolean isHandStraight(Hand h, HandScore hs) {

		boolean bIsStraight = false;
		Card highCard = null;
		if (Hand.isStraight(h.getCardsInHand(), highCard)) {
			bIsStraight = true;
			hs.setHandStrength(eHandStrength.Straight.getHandStrength());
			ArrayList<Card> kickers = new ArrayList<Card>();
			hs.setKickers(kickers);
			hs.setLoHand(0);
			if (h.CardsInHand.get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr() == 14
					&& h.CardsInHand.get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr() == 2) {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			} else {
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
			}
		}
		return bIsStraight;
	}

	public static boolean isHandThreeOfAKind(Hand h, HandScore hs) {

		boolean isThreeOfAKind = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FifthCard.getCardNo()).geteRank()) {
			isThreeOfAKind = true;
			hs.setHandStrength(eHandStrength.ThreeOfAKind.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			hs.setKickers(kickers);
		}

		return isThreeOfAKind;
	}

	public static boolean isHandTwoPair(Hand h, HandScore hs) {

		boolean isTwoPair = false;

		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank()) {
			if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
					.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
				isTwoPair = true;
				hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
				hs.setKickers(kickers);
			} else if (h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank() == h.getCardsInHand()
					.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
				isTwoPair = true;
				hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
				hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
				hs.setLoHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
				ArrayList<Card> kickers = new ArrayList<Card>();
				kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
				hs.setKickers(kickers);
			}
		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()
				&& h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank() == h.getCardsInHand()
						.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isTwoPair = true;
			hs.setHandStrength(eHandStrength.TwoPair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return isTwoPair;
	}

	public static boolean isHandPair(Hand h, HandScore hs) {
		boolean isPair = false;
		if (h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.SecondCard.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);

		} else if (h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.ThirdCard.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FourthCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()));
			hs.setKickers(kickers);
		} else if (h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank() == h.getCardsInHand()
				.get(eCardNo.FourthCard.getCardNo()).geteRank()) {
			isPair = true;
			hs.setHandStrength(eHandStrength.Pair.getHandStrength());
			hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
			hs.setLoHand(0);
			ArrayList<Card> kickers = new ArrayList<Card>();
			kickers.add(h.getCardsInHand().get(eCardNo.FirstCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.SecondCard.getCardNo()));
			kickers.add(h.getCardsInHand().get(eCardNo.ThirdCard.getCardNo()));
			hs.setKickers(kickers);
		}
		return isPair;
	}

	public static boolean isHandHighCard(Hand h, HandScore hs) {
		hs.setHandStrength(eHandStrength.HighCard.getHandStrength());
		hs.setHiHand(h.getCardsInHand().get(eCardNo.FifthCard.getCardNo()).geteRank().getiRankNbr());
		hs.setLoHand(0);
		ArrayList<Card> kickers = new ArrayList<Card>();
		hs.setKickers(kickers);
		return true;
	}

	public static Hand compareHands(Hand h1, Hand h2) {
		if (h1.handScore.getHandStrength() > h2.handScore.getHandStrength()) {
			return h1;
		} else if (h1.handScore.getHandStrength() < h2.handScore.getHandStrength()) {
			return h2;
		} else { // hs == hs
			if (h1.handScore.getHiHand() > h2.handScore.getHiHand()) {
				return h1;
			} else if (h1.handScore.getHiHand() < h2.handScore.getHiHand()) {
				return h2;
			} else { // hihand == hihand
				if (Card.CardRank.compare(h1.handScore.getKickers().get(-1), h1.handScore.getKickers().get(-1)) > 0) {
					return h2;
				} else if (Card.CardRank.compare(h1.handScore.getKickers().get(-1),
						h1.handScore.getKickers().get(-1)) < 0) {
					return h1;
				} else { // kicker1 == kicker1 We gotta do this maybe
					return h2;
				}
			}
		}
	}
}
