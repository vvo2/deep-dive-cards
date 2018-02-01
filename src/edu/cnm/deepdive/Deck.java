package edu.cnm.deepdive;

import java.util.Random;

public class Deck {

  private Card[] cards;
  private Random rng; //added for shuffle
  private int nextCardToDraw = 0;

  public Card[] getCards() {
    return cards;
  }

  public Deck(){
    rng = new Random(); //added for shuffle
    cards = new Card[Suit.values().length * Rank.values().length]; //more specific than instead of 52
    int slot = 0;
    for (Suit suit : Suit.values()){//create 4 suit first
      for (Rank rank : Rank.values()) { //then create all the ranks
        Card card = new Card(rank, suit);
        cards [slot] = card;
        slot++; // same as cards [slot++] = card;
      }
    }

  }
  public void shuffle(){ //probability of 1/n, mathamaticly proven
    for (int target = cards.length - 1; target > 0; target--){
      int source = rng.nextInt(target +1);
      if (source != target) {
        Card temp = cards[target];
        cards[target] = cards[source];
        cards[source] = temp;
      }
    }
    nextCardToDraw = 0;
  }
  //FIXME - Do somthing smarter with the out-of-bounds problems.
  public Card draw()throws ArrayIndexOutOfBoundsException {
    return cards[nextCardToDraw++]; //draw a card then increment it
  }

}
