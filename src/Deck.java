/**
 * This class represents a deck of cards.
 * It provides functionalities to create, shuffle, and manipulate a deck of cards.
 * 
 * New Java 1.8 features used:
 * - Streams and lambda expressions for concise and readable code.
 * - Collectors for joining strings.
 * - Method references for cleaner code.
 * 
 * Note: This class is not thread-safe.
 * 
 * @version 1.8
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private ArrayList<Card> deck;

    /**
     * Copy constructor for creating a deep copy of an existing deck.
     * 
     * @param original the original deck to copy
     */
    Deck(Deck original) {
        this.deck = new ArrayList<>();

        original.deck.forEach(card_temp -> {
            Card deepCopy = new Card(card_temp.getRank(), card_temp.getSuit());
            this.deck.add(deepCopy);
        });
    }

    /**
     * Default constructor for creating a standard deck of 52 cards.
     */
    Deck() {
        this.deck = new ArrayList<>();

        IntStream.range(0, 4).forEach(suit -> 
            IntStream.range(0, 13).forEach(rank -> 
                this.deck.add(new Card(rank, suit))
            )
        );
    }

    /**
     * Returns a string representation of the deck.
     * 
     * @return a string representation of the deck
     */
    @Override
    public String toString() {
        return deck.stream()
                   .map(Card::toString)
                   .collect(Collectors.joining());
    }

    /**
     * Returns the total number of cards in the deck.
     * 
     * @return the total number of cards
     */
    public int getTotalCards() {
        return deck.size();
    }

    /**
     * Shuffles the deck by swapping 100 pairs of cards.
     */
    public void shuffle() {
        Random generator = new Random();

        IntStream.range(0, 100).forEach(i -> {
            int index_1 = generator.nextInt(this.deck.size());
            int index_2 = generator.nextInt(this.deck.size());

            Card temp = deck.get(index_2);
            deck.set(index_2, deck.get(index_1));
            deck.set(index_1, temp);
        });
    }

    /**
     * Deals the top card from the deck.
     * 
     * @return the top card
     */
    public Card dealCard() {
        return deck.remove(0);
    }

    /**
     * Deals a random card from the deck.
     * 
     * @return a random card
     */
    public Card dealRandomCard() {
        Random generator = new Random();
        int index = generator.nextInt(this.deck.size());
        return deck.remove(index);
    }

    /**
     * Removes a specific card from the deck.
     * 
     * @param card the card to remove
     */
    public void removeCard(Card card) {
        deck.removeIf(c -> c.getRank() == card.getRank() && c.getSuit() == card.getSuit());
    }

    /**
     * Removes multiple cards from the deck based on their string representations.
     * 
     * @param c an array of string representations of the cards to remove
     */
    public void removeCards(String[] c) {
        for (String cardStr : c) {
            Card temp = new Card(cardStr);
            deck.removeIf(card -> card.getRank() == temp.getRank() && card.getSuit() == temp.getSuit());
        }
    }

    /**
     * Returns the card at the specified index.
     * 
     * @param index the index of the card to return
     * @return the card at the specified index
     */
    public Card getCard(int index) {
        return deck.get(index);
    }

    /**
     * Adds a card to the deck.
     * 
     * @param c the card to add
     */
    public void addCard(Card c) {
        this.deck.add(c);
    }

    /**
     * Checks if the deck contains a specific card.
     * 
     * @param card the card to check for
     * @return true if the deck contains the card, false otherwise
     */
    public boolean containsCard(Card card) {
        return deck.contains(card);
    }

    /**
     * Converts the deck to an array of cards.
     * 
     * @return an array of cards
     */
    public Card[] toArray() {
        return deck.toArray(new Card[0]);
    }

    /**
     * Clears the deck of all cards.
     */
    public void clearDeck() {
        this.deck.clear();
    }
}
