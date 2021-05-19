package handRank;


import models.Card;
import models.Suit;
import models.Value;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import functions.Flush;
import functions.FourOfKind;
import functions.FullHouse;
import functions.HighCard;
import functions.Pair;
import functions.Straight;
import functions.StraightFlush;
import functions.ThreeOfKind;
import functions.TwoPairs;

import java.util.List;

import static java.util.Arrays.asList;

public class PockerHandRankPartTest {
	CardRankComparator cardRankComparator;

    @BeforeEach
    public void initialize(){
    	cardRankComparator = new CardRankComparatorImpl(new HighCard(), new Pair(),
                new TwoPairs(), new ThreeOfKind(), new Straight(),
                new Flush(), new FullHouse(), new FourOfKind(), new StraightFlush()) {
        };
    }

    @Test
    public void whiteHasAceCard() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._3, Suit.D),
                new Card(Value._5, Suit.S),
                new Card(Value._9, Suit.C),
                new Card(Value.K, Suit.D));
        List<Card> white = asList(
                new Card(Value._2, Suit.C),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.S),
                new Card(Value._8, Suit.C),
                new Card(Value.A, Suit.H));
        PockerHandRankPart pockerHandRankPart = new PockerHandRankPart(black, white, this.cardRankComparator);
        Assert.assertEquals("White wins. - with high card: Ace", pockerHandRankPart.pockerHandRankPart());
    }
    
	
    @Test
    public void fullHouseForBlack4Over2ThanWhite() {
        List<Card> black = asList(
                new Card(Value._2, Suit.H),
                new Card(Value._4, Suit.S),
                new Card(Value._4, Suit.C),
                new Card(Value._2, Suit.D),
                new Card(Value._4, Suit.H));
        List<Card> white = asList(
                new Card(Value._2, Suit.S),
                new Card(Value._8, Suit.S),
                new Card(Value.A, Suit.S),
                new Card(Value.Q, Suit.S),
                new Card(Value._3, Suit.S));
        PockerHandRankPart pockerHandRankPart = new PockerHandRankPart(black, white, this.cardRankComparator);
        Assert.assertEquals("Black wins. - with full house: 4 over 2", pockerHandRankPart.pockerHandRankPart());
    }

	 
    @Test
    public void hightCardeForBlack9ThanWhite() {
        List<Card> black = asList(
        		 new Card(Value._2, Suit.H),
                 new Card(Value._3, Suit.D),
                 new Card(Value._5, Suit.S),
                 new Card(Value._9, Suit.C),
                 new Card(Value.K, Suit.D));
        List<Card> white = asList(
                new Card(Value._2, Suit.C),
                new Card(Value._3, Suit.H),
                new Card(Value._4, Suit.S),
                new Card(Value._8, Suit.C),
                new Card(Value.K, Suit.H));
        PockerHandRankPart pockerHandRankPart = new PockerHandRankPart(black, white, this.cardRankComparator);
        Assert.assertEquals("Black wins. - with high card: 9", pockerHandRankPart.pockerHandRankPart());
    }

    @Test
    public void tie() {
        List<Card> black = asList(
        		 new Card(Value._2, Suit.H),
                 new Card(Value._3, Suit.D),
                 new Card(Value._5, Suit.S),
                 new Card(Value._9, Suit.C),
                 new Card(Value.K, Suit.D));
        List<Card> white = asList(
                new Card(Value._2, Suit.D),
                new Card(Value._3, Suit.H),
                new Card(Value._5, Suit.C),
                new Card(Value._9, Suit.S),
                new Card(Value.K, Suit.H));
        PockerHandRankPart pockerHandRankPart = new PockerHandRankPart(black, white, this.cardRankComparator);
        Assert.assertEquals("Tie.", pockerHandRankPart.pockerHandRankPart());
    }
}
