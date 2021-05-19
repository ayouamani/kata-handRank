package functions;

import handRank.Rank;
import models.Card;

public class Flush extends Rank {
    public boolean isFlush(Card... cards) {
        return repeatSuit(5, cards).size() == 1;
    }
}
