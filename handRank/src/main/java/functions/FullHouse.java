package functions;

import java.util.List;
import java.util.Map;

import handRank.Rank;
import models.Card;
import models.Value;

public class FullHouse extends Rank {
    public boolean isFullHouse(Card... cards) {
        return duplValue(3, cards).size() == 1 && duplValue(2, cards).size() == 1;
    }

    public StringBuffer getFullHouseValueMsg(Card ... cards){
        List<Map.Entry<Value, Long>> sorted = sortKeyByValueIsGrouping(cards);
        StringBuffer sb = new StringBuffer();

        sb.append(sorted.get(0).getKey().getContent());
        sb.append(" over ");
        sb.append(sorted.get(1).getKey().getContent());

        return sb;
    }
}
