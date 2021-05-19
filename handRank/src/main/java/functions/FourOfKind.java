package functions;

import handRank.Rank;
import models.Card;

public class FourOfKind extends Rank {
    public boolean isFourOfKind(Card... cards) {
        return duplValue(4, cards).size() == 1 && duplValue(1, cards).size() == 1;
    }
}
