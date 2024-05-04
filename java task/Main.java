import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

// Enum for card suits
enum Suit {
    SPADE, CLUB, HEART, DIAMOND
}

// Enum for card ranks
enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}

// Class representing a single card
class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// Comparator for sorting cards
class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card card1, Card card2) {
        // First, compare based on color
        int colorCompare = getColorValue(card1.getSuit()) - getColorValue(card2.getSuit());
        if (colorCompare != 0) {
            return colorCompare;
        }
        // Then, within each color, compare based on suit
        int suitCompare = card1.getSuit().ordinal() - card2.getSuit().ordinal();
        if (suitCompare != 0) {
            return suitCompare;
        }
        // Finally, compare based on rank
        return card1.getRank().ordinal() - card2.getRank().ordinal();
    }

    // Helper method to determine color value
    private int getColorValue(Suit suit) {
        return (suit == Suit.HEART || suit == Suit.DIAMOND) ? 1 : 0;
    }
}

// Class representing a deck of cards
class Deck {
    private List<Card> cards;

    // Constructor to initialize deck with 52 cards
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Method to shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Method to draw a card from the deck
    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }

    // Method to draw multiple cards from the deck
    public List<Card> drawCards(int numCards) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            drawnCards.add(drawCard());
        }
        return drawnCards;
    }

    // Method to check the size of the deck
    public int size() {
        return cards.size();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new deck
        Deck deck = new Deck();

        // Shuffle the deck (optional)
        deck.shuffle();

        // Draw 20 cards from the deck
        List<Card> drawnCards = deck.drawCards(20);

        // Sort the drawn cards using custom comparator
        Collections.sort(drawnCards, new CardComparator());

        // Display the sorted drawn cards
        for (Card card : drawnCards) {
            System.out.println(card);
        }
    }
}
