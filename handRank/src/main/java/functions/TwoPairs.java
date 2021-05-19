package functions;




import java.util.List;
import java.util.stream.Collectors;

import handRank.Rank;
import models.Card;

public class TwoPairs extends Rank {
    public boolean isTwoPairs(Card... cards) {
        return duplValue(2, cards).size() == 2;
    }

    public List<Card> getTwoPairCardHighestValue(Card ... cards) {
        return getHighestByDupValue(cards);
    }

    public List<Card> getHighestRemainingCardOfTwoPair(List<Card> cards){
        List<Card> getTwoPairCardHighestValue = getTwoPairCardHighestValue(cards.toArray(new Card[cards.size()]));
        return cards.stream()
                .filter(n -> getTwoPairCardHighestValue.stream()
                        .filter(m -> m.getValue().ordinal() == n.getValue().ordinal()).count() == 0)
                .collect(Collectors.toList());
    }

}
