package edu.cnm.deepdive;

public class Card {

  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit){//constructor
    this.rank = rank; //assign the field rank to parameter rank
    this.suit = suit;
  }

  public Rank getRank() {
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return String.format("%2s%s", rank, suit ); //%2s is 2 space width for the rank
  }
}
