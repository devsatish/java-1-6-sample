/**
 * This class represents a playing card with a rank and suit.
 * It provides methods to create a card from a rank and suit or from a string representation.
 * It also includes utility methods to convert ranks to strings and to parse cards from strings.
 * 
 * This class uses Java 1.8 features such as Optional and lambda expressions.
 * 
 * @author scrub
 */
import java.util.Optional;
import java.util.stream.IntStream;

public class Card {
    private int rank, suit;

    private static String[] suits = { "s", "h", "c", "d" };
    private static String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };

    Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    Card(String card) {
        String cardRank = card.substring(0, 1);
        String cardSuit = card.substring(1, 2);

        this.rank = IntStream.range(0, 13)
                .filter(r -> cardRank.equals(ranks[r]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid card rank: " + cardRank));

        this.suit = IntStream.range(0, 4)
                .filter(s -> cardSuit.equals(suits[s]))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid card suit: " + cardSuit));
    }

    public static String rankAsString(int n) {
        return ranks[n];
    }

    @Override
    public String toString() {
        return ranks[rank] + "" + suits[suit];
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    /**
     * Parses a string representation of a card and returns an Optional containing the card.
     * If the string is invalid, an empty Optional is returned.
     * 
     * This method uses Java 1.8 Optional to handle the possibility of an invalid card string.
     * 
     * @param card the string representation of the card
     * @return an Optional containing the card, or an empty Optional if the string is invalid
     */
    public static Optional<Card> fromString(String card) {
        try {
            return Optional.of(new Card(card));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
