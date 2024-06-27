import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a deck of cards.
 */
public class Deck {

    private ArrayList<Card> deck;

    /**
     * Creates a deep copy of the given deck.
     *
     * @param original the deck to copy
     */
    Deck(Deck original) {
        this.deck = new ArrayList<>();

        for (int i = 0; i < original.getTotalCards(); i++) {
            var cardTemp = original.getCard(i);
            var deepCopy = new Card(cardTemp.getRank(), cardTemp.getSuit());
            this.deck.add(deepCopy);
        }
    }

    /**
     * Creates a standard deck of 52 cards.
     */
    Deck() {
        this.deck = new ArrayList<>();

        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                this.deck.add(new Card(rank, suit));
            }
        }
    }

    @Override
    public String toString() {
        var strDeck = new StringBuilder();
        for (var card : deck) {
            strDeck.append(card.toString());
        }
        return strDeck.toString();
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
        var generator = new Random();

        for (int i = 0; i < 100; i++) {
            var index1 = generator.nextInt(this.deck.size());
            var index2 = generator.nextInt(this.deck.size());

            var temp = deck.get(index2);
            deck.set(index2, deck.get(index1));
            deck.set(index1, temp);
        }
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
        var generator = new Random();
        var index = generator.nextInt(this.deck.size());
        var randomCard = deck.get(index);
        deck.remove(index);
        return randomCard;
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
     * Removes multiple cards from the deck.
     *
     * @param c an array of card descriptions to remove
     */
    public void removeCards(String[] c) {
        for (var cardStr : c) {
            var temp = new Card(cardStr);
            deck.removeIf(card -> card.getRank() == temp.getRank() && card.getSuit() == temp.getSuit());
        }
    }

    /**
     * Gets the card at the specified index.
     *
     * @param index the index of the card
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
     * Converts the deck to an array.
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
