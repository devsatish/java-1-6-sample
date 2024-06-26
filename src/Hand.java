import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Hand extends Deck {

    private ArrayList<Card> hand;
    public int hand_rank;

    Hand() {
        this.hand = new ArrayList<>();
        this.hand_rank = 0;
    }

    Hand(Hand original) {
        this.hand = new ArrayList<>();
        original.hand.forEach(card -> this.hand.add(new Card(card.getRank(), card.getSuit())));
    }

    Hand(String[] cards) {
        this.hand = new ArrayList<>();
        Arrays.stream(cards).map(Card::new).forEach(this.hand::add);
    }

    @Override
    public void removeCard(Card card) {
        hand.removeIf(c -> c.getRank() == card.getRank() && c.getSuit() == card.getSuit());
    }

    @Override
    public Card getCard(int index) {
        return hand.get(index);
    }

    @Override
    public void addCard(Card c) {
        this.hand.add(c);
    }

    public String handToString() {
        return hand.stream().map(Card::toString).collect(Collectors.joining(" ", "[ ", " ]"));
    }

    public void setHandRank(int hr) {
        this.hand_rank = hr;
    }

    public int getHandRank() {
        return this.hand_rank;
    }

    @Override
    public int getTotalCards() {
        return hand.size();
    }

    @Override
    public Card[] toArray() {
        return hand.toArray(new Card[0]);
    }

    public void removeIndex(int n) {
        hand.remove(n);
    }

    public boolean isPair() {
        return hand.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values().stream().anyMatch(count -> count == 2);
    }

    public int whichKind() {
        return hand.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values().stream().max(Long::compare).orElse(0L).intValue();
    }

    public boolean countKind(int kind_Number) {
        return hand.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values().stream().anyMatch(count -> count == kind_Number);
    }

    public boolean isOnePair() {
        return countKind(2);
    }

    public boolean isTwoPair() {
        return hand.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()))
                .values().stream().filter(count -> count == 2).count() == 2;
    }

    public boolean isThreeOfAKind() {
        return countKind(3);
    }

    public boolean isFullHouse() {
        return isThreeOfAKind() && isOnePair();
    }

    public boolean isFourOfAKind() {
        return countKind(4);
    }

    public boolean isColor() {
        return hand.stream().allMatch(card -> card.getSuit() == hand.get(0).getSuit());
    }

    public boolean isStraight() {
        int[] rank = hand.stream().mapToInt(Card::getRank).sorted().toArray();
        if (rank[0] == 0 && rank[1] == 10) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (rank[i] != rank[i + 1] - 1) {
                return false;
            }
        }
        return true;
    }

    public boolean mataAces() {
        return hand.stream().filter(card -> card.getRank() == 0).count() > 1;
    }

    public int onePairTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();

        int[] hand_one_values = getHandValuesForTieBreak(hand_one);
        int[] hand_two_values = getHandValuesForTieBreak(hand_two);

        return compareHandValues(hand_one_values, hand_two_values);
    }

    public int twoPairTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();

        int[] hand_one_values = getTwoPairValuesForTieBreak(hand_one);
        int[] hand_two_values = getTwoPairValuesForTieBreak(hand_two);

        return compareHandValues(hand_one_values, hand_two_values);
    }

    public int terciaTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();

        int[] hand_one_values = getTerciaValuesForTieBreak(hand_one);
        int[] hand_two_values = getTerciaValuesForTieBreak(hand_two);

        return compareHandValues(hand_one_values, hand_two_values);
    }

    public int fullTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();

        int[] hand_one_values = getFullHouseValuesForTieBreak(hand_one);
        int[] hand_two_values = getFullHouseValuesForTieBreak(hand_two);

        return compareHandValues(hand_one_values, hand_two_values);
    }

    public int pokerTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();

        int[] hand_one_values = getPokerValuesForTieBreak(hand_one);
        int[] hand_two_values = getPokerValuesForTieBreak(hand_two);

        return compareHandValues(hand_one_values, hand_two_values);
    }

    public int straightTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(Card::getRank).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(Card::getRank).sorted().toArray();

        int hand_one_value = (hand_one[0] == 0 && hand_one[1] == 10) ? 14 : hand_one[4];
        int hand_two_value = (hand_two[0] == 0 && hand_two[1] == 10) ? 14 : hand_two[4];

        return Integer.compare(hand_one_value, hand_two_value);
    }

    public int colorTieBreak(Hand opponent) {
        int[] hand_one = hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();
        int[] hand_two = opponent.hand.stream().mapToInt(card -> card.getRank() == 0 ? 14 : card.getRank()).sorted().toArray();

        for (int i = 0; i < 5; i++) {
            int comparison = Integer.compare(hand_one[i], hand_two[i]);
            if (comparison != 0) {
                return comparison;
            }
        }
        return 0;
    }

    public void deleteHand() {
        this.hand.clear();
    }

    private int[] getHandValuesForTieBreak(int[] hand) {
        int[] hand_values = new int[4];
        if (hand[0] == hand[1]) {
            hand_values[0] = hand[0];
            hand_values[1] = hand[4];
            hand_values[2] = hand[3];
            hand_values[3] = hand[2];
        } else if (hand[1] == hand[2]) {
            hand_values[0] = hand[1];
            hand_values[1] = hand[4];
            hand_values[2] = hand[3];
            hand_values[3] = hand[0];
        } else if (hand[2] == hand[3]) {
            hand_values[0] = hand[2];
            hand_values[1] = hand[4];
            hand_values[2] = hand[1];
            hand_values[3] = hand[0];
        } else {
            hand_values[0] = hand[3];
            hand_values[1] = hand[2];
            hand_values[2] = hand[1];
            hand_values[3] = hand[0];
        }
        return hand_values;
    }

    private int[] getTwoPairValuesForTieBreak(int[] hand) {
        int[] hand_values = new int[3];
        if (hand[0] == hand[1]) {
            hand_values[0] = hand[1];
            if (hand[2] == hand[3]) {
                hand_values[1] = hand[3];
                hand_values[2] = hand[4];
            } else {
                hand_values[1] = hand[4];
                hand_values[2] = hand[2];
            }
        } else {
            hand_values[0] = hand[1];
            hand_values[1] = hand[3];
            hand_values[2] = hand[0];
        }
        return hand_values;
    }

    private int[] getTerciaValuesForTieBreak(int[] hand) {
        int[] hand_values = new int[3];
        if (hand[0] == hand[1]) {
            hand_values[0] = hand[2];
            hand_values[1] = hand[3];
            hand_values[2] = hand[4];
        } else if (hand[1] == hand[2]) {
            hand_values[0] = hand[2];
            hand_values[1] = hand[0];
            hand_values[2] = hand[4];
        } else {
            hand_values[0] = hand[2];
            hand_values[1] = hand[0];
            hand_values[2] = hand[1];
        }
        return hand_values;
    }

    private int[] getFullHouseValuesForTieBreak(int[] hand) {
        int[] hand_values = new int[2];
        if (hand[1] == hand[2]) {
            hand_values[0] = hand[0];
            hand_values[1] = hand[4];
        } else {
            hand_values[0] = hand[4];
            hand_values[1] = hand[0];
        }
        return hand_values;
    }

    private int[] getPokerValuesForTieBreak(int[] hand) {
        int[] hand_values = new int[2];
        if (hand[0] == hand[1]) {
            hand_values[0] = hand[0];
            hand_values[1] = hand[4];
        } else {
            hand_values[0] = hand[4];
            hand_values[1] = hand[0];
        }
        return hand_values;
    }

    private int compareHandValues(int[] hand_one_values, int[] hand_two_values) {
        for (int i = 0; i < hand_one_values.length; i++) {
            int comparison = Integer.compare(hand_one_values[i], hand_two_values[i]);
            if (comparison != 0) {
                return comparison;
            }
        }
        return 0;
    }
}
