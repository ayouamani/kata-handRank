package functions;

import handRank.Rank;
import models.Card;


public class StraightFlush extends Rank {
    public boolean isStraightFlush(Card... cards) {
        return isInSequence(sortByValue(cards)) && repeatSuit(5, cards).size() == 1;
    }
}
