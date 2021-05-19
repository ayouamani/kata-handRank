package functions;

import handRank.Rank;
import models.Card;

public class HighCard extends Rank {
   
	public boolean isHighCard(Card... cards) {
        return duplValue(1, cards).size() == 5;
    }
}
