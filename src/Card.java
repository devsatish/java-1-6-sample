/**
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

    public static Optional<Card> fromString(String card) {
        try {
            return Optional.of(new Card(card));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
