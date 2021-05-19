package functions;

import handRank.Rank;
import models.Card;


public class ThreeOfKind extends Rank {
    public boolean isThreeOfKind(Card... cards) {
        return duplValue(3, cards).size() == 1 && duplValue(1, cards).size() == 2;
    }
}
