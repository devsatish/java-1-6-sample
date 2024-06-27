/**
 * Represents a playing card with a rank and suit.
 * 
 * <p>This class provides methods to create a card from a rank and suit or from a string representation.
 * It also includes methods to get the rank and suit of the card, and to convert the rank to a string.</p>
 * 
 * <p>Example usage:</p>
 * {@snippet :
 * Card card = new Card(0, 1); // Ace of Hearts
 * System.out.println(card); // Outputs: Ah
 * }
 * 
 * <p>Another example:</p>
 * {@snippet :
 * Card card = new Card("Ah"); // Ace of Hearts
 * System.out.println(card.getRank()); // Outputs: 0
 * System.out.println(card.getSuit()); // Outputs: 1
 * }
 * 
 * @author scrub
 */
public class Card {
    private int rank, suit;

    private static final String[] suits = { "s", "h", "c", "d" };
    private static final String[] ranks = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };

    Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    Card(String card) {
        var cardRank = card.substring(0, 1);
        var cardSuit = card.substring(1, 2);

        for (var r = 0; r < 13; r++) {
            if (cardRank.equals(ranks[r])) {
                this.rank = r;
            }
        }

        for (var s = 0; s < 4; s++) {
            if (cardSuit.equals(suits[s])) {
                this.suit = s;
            }
        }
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
}
