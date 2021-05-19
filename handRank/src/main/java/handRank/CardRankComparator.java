package handRank;


import models.Card;
import models.Value;

import java.util.List;

public interface CardRankComparator {
	
    int getCategoryOfCard(Card... cards);
    Card getHighestCard(int index, Card ... cards);
    Value getMaxDuplicateCard(Card ... cards);
    Value getPairCardValue(Card ... cards);
    List<Card> getTwoPairCardHighestValue(Card ... cards);
    List<Card> getRemainingCardOfPair(List<Card> cards);
    List<Card> getHighestRemainingCardOfTwoPair(List<Card> cards);
    StringBuffer getFullHouseValueMsg(Card ... cards);
}
