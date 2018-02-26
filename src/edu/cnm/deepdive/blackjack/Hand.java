package edu.cnm.deepdive.blackjack;

import edu.cnm.deepdive.Card;
import edu.cnm.deepdive.Deck;
import edu.cnm.deepdive.Rank;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hand implements Comparable<Hand>, Iterable<Card> {



  private static final int HIGH_ACE_INCREMENT = 10;
  private static final int WINNING_TOTAL = 21;
  private static final int BLACKJACK_NUM_CARDS = 2;

  private static Map<Rank, Integer> values;

  private List<Card> cards;
  private boolean bust;
  private boolean blackjack;
  private int value;

  static {
    values = Map.ofEntries(
        Map.entry(Rank.ACE, 1),
        Map.entry(Rank.TWO, 2),
        Map.entry(Rank.THREE, 3),
        Map.entry(Rank.FOUR, 4),
        Map.entry(Rank.FIVE, 5),
        Map.entry(Rank.SIX, 6),
        Map.entry(Rank.SEVEN, 7),
        Map.entry(Rank.EIGHT, 8),
        Map.entry(Rank.NINE, 9),
        Map.entry(Rank.TEN, 10),
        Map.entry(Rank.JACK, 10),
        Map.entry(Rank.QUEEN, 10),
        Map.entry(Rank.KING, 10)
    );
  }
//TODO public class compareHand,
  public Hand() { //TODO? Hand1.compareTo(hand2)
    cards = new LinkedList<>(); //TODO cards = hand1, cards = hand2
  }

  public void add(Card card) {
    cards.add(card);  //TODO (cards.Hand).compareTo(cards.add(card))
    update();
  }

  public void clear() {
    cards.clear();
    bust = false;
    blackjack = false;
    value = 0;
  }

  public boolean isBust() {
    return bust;
  }

  public boolean isBlackjack() {
    return blackjack;
  }

  public int value() {
    return value;
  }

  private void update() {
    int aces = 0;
    value = 0;
    bust = false;
    blackjack = false;
    for (Card card : cards) {
      value += values.get(card.getRank());
      if (card.getRank() == Rank.ACE){
        aces++;
      }
    }
    for (int i = 0; i < aces ; i++) {
      if (value + HIGH_ACE_INCREMENT <= WINNING_TOTAL) {
        value += HIGH_ACE_INCREMENT;
      }
    }
    if (value > WINNING_TOTAL) {
      bust = true;
      value = 0;
    } else if (value == WINNING_TOTAL && cards.size() == BLACKJACK_NUM_CARDS) {
      blackjack = true;
    }
  }

  @Override
  public Iterator<Card> iterator() {
    return null;
  }

  @Override
  public int compareTo(Hand other) {
    int result = Boolean.compare((isBlackjack()), other.isBlackjack());
    if (result == 0) {
      result = Integer.compare(this.value(), other.value);
    }
    return result;
  }

  public int size() {
    return cards.size();
  }
}
