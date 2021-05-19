package functions;

import handRank.Rank;
import models.Card;

public class Straight extends Rank {
    public boolean isStraight(Card... cards) {
        return isInSequence(sortByValue(cards));
    }
}
