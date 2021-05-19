package functions;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import handRank.Rank;
import models.Card;
import models.Value;

public class Pair extends Rank {
    public boolean isPair(Card... cards) {
        return duplValue(2, cards).size() == 1;
    }

    public Value getPairCardValue(Card ... cards) {
        return Stream.of(cards).collect(Collectors.groupingBy(Card::getValue,
                Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()).get().getKey();
    }

    public List<Card> getRestCardOfPair(List<Card> cards){
        return cards.stream()
                .filter(e -> e.getValue().ordinal() != getPairCardValue(cards.toArray(new Card[cards.size()])).ordinal())
                .collect(Collectors.toList());
    }
}
