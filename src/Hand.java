/**
 * This class represents a hand of cards in a card game.
 * It extends the Deck class and provides various methods to manipulate and evaluate the hand.
 * 
 * <p>Example usage:</p>
 * {@snippet :
 * Hand hand = new Hand(new String[]{"AS", "KH", "QC", "JD", "10S"});
 * System.out.println(hand.handToString());
 * }
 * 
 * @version Java 17
 * @since 1.0
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand extends Deck {

    private List<Card> hand;
    public int hand_rank;

    Hand() {
        this.hand = new ArrayList<>();
        this.hand_rank = 0;
    }

    Hand(Hand original) {
        this.hand = new ArrayList<>();
        for (int i = 0; i < original.getTotalCards(); i++) {
            var card_temp = original.getCard(i);
            var deepCopy = new Card(card_temp.getRank(), card_temp.getSuit());
            this.hand.add(deepCopy);
        }
    }

    Hand(String[] cards) {
        this.hand = new ArrayList<>();
        for (var card : cards) {
            var temp = new Card(card);
            this.hand.add(temp);
        }
    }

    @Override
    public void removeCard(Card card) {
        for (var i = 0; i < hand.size(); i++) {
            if (card.getRank() == hand.get(i).getRank() && card.getSuit() == hand.get(i).getSuit()) {
                hand.remove(i);
                break;
            }
        }
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
        var strHand = new StringBuilder("[ ");
        for (var card : this.hand) {
            strHand.append(card.toString()).append(" ");
        }
        strHand.append("]");
        return strHand.toString();
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
        for (var i = 0; i < 4; i++) {
            var card_rank = hand.get(i).getRank();
            for (var n = i + 1; n < 5; n++) {
                if (card_rank == hand.get(n).getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int whichKind() {
        var count_kind = 0;
        for (var i = 0; i < 4; i++) {
            var card_rank = hand.get(i).getRank();
            for (var n = i + 1; n < 5; n++) {
                if (card_rank == hand.get(n).getRank()) {
                    count_kind++;
                }
            }
        }
        return count_kind;
    }

    public boolean countKind(int kind_Number) {
        var count_kind = 0;
        for (var i = 0; i < 4; i++) {
            var card_rank = hand.get(i).getRank();
            for (var n = i + 1; n < 5; n++) {
                if (card_rank == hand.get(n).getRank()) {
                    count_kind++;
                }
            }
        }
        return count_kind == kind_Number;
    }

    public boolean isOnePair() {
        return countKind(1);
    }

    public boolean isTwoPair() {
        return countKind(2);
    }

    public boolean isThreeOfAKind() {
        return countKind(3);
    }

    public boolean isFullHouse() {
        return countKind(4);
    }

    public boolean isFourOfAKind() {
        return countKind(6);
    }

    public boolean isColor() {
        var card_suit = hand.get(0).getSuit();
        for (var i = 1; i < 5; i++) {
            if (card_suit != hand.get(i).getSuit()) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraight() {
        var rank = new int[5];
        for (var i = 0; i < 5; i++) {
            rank[i] = hand.get(i).getRank();
        }
        Arrays.sort(rank);

        if (rank[0] == 0 && rank[1] == 10) {
            return true;
        } else {
            for (var i = 0; i < 4; i++) {
                if (rank[i] != rank[i + 1] - 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean mataAces() {
        var count_aces = 0;
        for (var card : hand) {
            if (card.getRank() == 0) {
                count_aces++;
            }
        }
        return count_aces > 1;
    }

    public int onePairTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];
        var hand_one_values = new int[4];
        var hand_two_values = new int[4];

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank() == 0 ? 14 : hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank() == 0 ? 14 : opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        if (hand_one[0] == hand_one[1]) {
            hand_one_values[0] = hand_one[0];
            hand_one_values[1] = hand_one[4];
            hand_one_values[2] = hand_one[3];
            hand_one_values[3] = hand_one[2];
        } else if (hand_one[1] == hand_one[2]) {
            hand_one_values[0] = hand_one[1];
            hand_one_values[1] = hand_one[4];
            hand_one_values[2] = hand_one[3];
            hand_one_values[3] = hand_one[0];
        } else if (hand_one[2] == hand_one[3]) {
            hand_one_values[0] = hand_one[2];
            hand_one_values[1] = hand_one[4];
            hand_one_values[2] = hand_one[1];
            hand_one_values[3] = hand_one[0];
        } else {
            hand_one_values[0] = hand_one[3];
            hand_one_values[1] = hand_one[2];
            hand_one_values[2] = hand_one[1];
            hand_one_values[3] = hand_one[0];
        }

        if (hand_two[0] == hand_two[1]) {
            hand_two_values[0] = hand_two[0];
            hand_two_values[1] = hand_two[4];
            hand_two_values[2] = hand_two[3];
            hand_two_values[3] = hand_two[2];
        } else if (hand_two[1] == hand_two[2]) {
            hand_two_values[0] = hand_two[1];
            hand_two_values[1] = hand_two[4];
            hand_two_values[2] = hand_two[3];
            hand_two_values[3] = hand_two[0];
        } else if (hand_two[2] == hand_two[3]) {
            hand_two_values[0] = hand_two[2];
            hand_two_values[1] = hand_two[4];
            hand_two_values[2] = hand_two[1];
            hand_two_values[3] = hand_two[0];
        } else {
            hand_two_values[0] = hand_two[3];
            hand_two_values[1] = hand_two[2];
            hand_two_values[2] = hand_two[1];
            hand_two_values[3] = hand_two[0];
        }

        if (hand_one_values[0] > hand_two_values[0]) {
            return 1;
        } else if (hand_one_values[0] < hand_two_values[0]) {
            return 2;
        } else {
            if (hand_one_values[1] > hand_two_values[1]) {
                return 1;
            } else if (hand_one_values[1] < hand_two_values[1]) {
                return 2;
            } else {
                if (hand_one_values[2] > hand_two_values[2]) {
                    return 1;
                } else if (hand_one_values[2] < hand_two_values[2]) {
                    return 2;
                } else {
                    if (hand_one_values[3] > hand_two_values[3]) {
                        return 1;
                    } else if (hand_one_values[3] < hand_two_values[3]) {
                        return 2;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    public int twoPairTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];
        var hand_one_values = new int[3];
        var hand_two_values = new int[3];

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank() == 0 ? 14 : hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank() == 0 ? 14 : opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        if (hand_one[0] == hand_one[1]) {
            hand_one_values[0] = hand_one[1];
            if (hand_one[2] == hand_one[3]) {
                hand_one_values[1] = hand_one[3];
                hand_one_values[2] = hand_one[4];
            } else {
                hand_one_values[1] = hand_one[4];
                hand_one_values[2] = hand_one[2];
            }
        } else {
            hand_one_values[0] = hand_one[1];
            hand_one_values[1] = hand_one[3];
            hand_one_values[2] = hand_one[0];
        }

        if (hand_two[0] == hand_two[1]) {
            hand_two_values[0] = hand_two[1];
            if (hand_two[2] == hand_two[3]) {
                hand_two_values[1] = hand_two[3];
                hand_two_values[2] = hand_two[4];
            } else {
                hand_two_values[1] = hand_two[4];
                hand_two_values[2] = hand_two[2];
            }
        } else {
            hand_two_values[0] = hand_two[1];
            hand_two_values[1] = hand_two[3];
            hand_two_values[2] = hand_two[0];
        }

        if (hand_one_values[1] > hand_two_values[1]) {
            return 1;
        } else if (hand_one_values[1] < hand_two_values[1]) {
            return 2;
        } else {
            if (hand_one_values[0] > hand_two_values[0]) {
                return 1;
            } else if (hand_one_values[0] < hand_two_values[0]) {
                return 2;
            } else {
                if (hand_one_values[2] > hand_two_values[2]) {
                    return 1;
                } else if (hand_one_values[2] < hand_two_values[2]) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
    }

    public int terciaTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];
        var hand_one_values = new int[3];
        var hand_two_values = new int[3];

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank() == 0 ? 14 : hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank() == 0 ? 14 : opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        if (hand_one[0] == hand_one[1]) {
            hand_one_values[0] = hand_one[2];
            hand_one_values[1] = hand_one[3];
            hand_one_values[2] = hand_one[4];
        } else if (hand_one[1] == hand_one[2]) {
            hand_one_values[0] = hand_one[2];
            hand_one_values[1] = hand_one[0];
            hand_one_values[2] = hand_one[4];
        } else {
            hand_one_values[0] = hand_one[2];
            hand_one_values[1] = hand_one[0];
            hand_one_values[2] = hand_one[1];
        }

        if (hand_two[0] == hand_two[1]) {
            hand_two_values[0] = hand_two[2];
            hand_two_values[1] = hand_two[3];
            hand_two_values[2] = hand_two[4];
        } else if (hand_two[1] == hand_two[2]) {
            hand_two_values[0] = hand_two[2];
            hand_two_values[1] = hand_two[0];
            hand_two_values[2] = hand_two[4];
        } else {
            hand_two_values[0] = hand_two[2];
            hand_two_values[1] = hand_two[0];
            hand_two_values[2] = hand_two[1];
        }

        if (hand_one_values[0] > hand_two_values[0]) {
            return 1;
        } else if (hand_one_values[0] < hand_two_values[0]) {
            return 2;
        } else {
            if (hand_one_values[2] > hand_two_values[2]) {
                return 1;
            } else if (hand_one_values[2] < hand_two_values[2]) {
                return 2;
            } else {
                if (hand_one_values[1] > hand_two_values[1]) {
                    return 1;
                } else if (hand_one_values[1] < hand_two_values[1]) {
                    return 2;
                } else {
                    return 0;
                }
            }
        }
    }

    public int fullTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];
        var hand_one_values = new int[2];
        var hand_two_values = new int[2];

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank() == 0 ? 14 : hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank() == 0 ? 14 : opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        if (hand_one[1] == hand_one[2]) {
            hand_one_values[0] = hand_one[0];
            hand_one_values[1] = hand_one[4];
        } else {
            hand_one_values[0] = hand_one[4];
            hand_one_values[1] = hand_one[0];
        }
        if (hand_two[1] == hand_two[2]) {
            hand_two_values[0] = hand_two[0];
            hand_two_values[1] = hand_two[4];
        } else {
            hand_two_values[0] = hand_two[4];
            hand_two_values[1] = hand_two[0];
        }

        if (hand_one_values[0] > hand_two_values[0]) {
            return 1;
        } else if (hand_one_values[0] < hand_two_values[0]) {
            return 2;
        } else {
            if (hand_one_values[1] > hand_two_values[1]) {
                return 1;
            } else if (hand_one_values[1] < hand_two_values[1]) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    public int pokerTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];
        var hand_one_values = new int[2];
        var hand_two_values = new int[2];

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank() == 0 ? 14 : hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank() == 0 ? 14 : opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        if (hand_one[0] == hand_one[1]) {
            hand_one_values[0] = hand_one[0];
            hand_one_values[1] = hand_one[4];
        } else {
            hand_one_values[0] = hand_one[4];
            hand_one_values[1] = hand_one[0];
        }
        if (hand_two[0] == hand_two[1]) {
            hand_two_values[0] = hand_two[0];
            hand_two_values[1] = hand_two[4];
        } else {
            hand_two_values[0] = hand_two[4];
            hand_two_values[1] = hand_two[0];
        }

        if (hand_one_values[0] > hand_two_values[0]) {
            return 1;
        } else if (hand_one_values[0] < hand_two_values[0]) {
            return 2;
        } else {
            if (hand_one_values[1] > hand_two_values[1]) {
                return 1;
            } else if (hand_one_values[1] < hand_two_values[1]) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    public int straightTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];
        var hand_one_value = 0;
        var hand_two_value = 0;

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        if (hand_one[0] == 0 && hand_one[1] == 10) {
            hand_one_value = 14;
        } else {
            hand_one_value = hand_one[4];
        }
        if (hand_two[0] == 0 && hand_two[1] == 10) {
            hand_two_value = 14;
        } else {
            hand_two_value = hand_two[4];
        }

        if (hand_one_value > hand_two_value) {
            return 1;
        } else if (hand_one_value < hand_two_value) {
            return 2;
        } else {
            return 0;
        }
    }

    public int colorTieBreak(Hand opponent) {
        var hand_one = new int[5];
        var hand_two = new int[5];

        for (var i = 0; i < 5; i++) {
            hand_one[i] = hand.get(i).getRank() == 0 ? 14 : hand.get(i).getRank();
            hand_two[i] = opponent.getCard(i).getRank() == 0 ? 14 : opponent.getCard(i).getRank();
        }

        Arrays.sort(hand_one);
        Arrays.sort(hand_two);

        for (var i = 0; i < 5; i++) {
            if (hand_one[i] > hand_two[i]) {
                return 1;
            } else if (hand_one[i] < hand_two[i]) {
                return 2;
            }
        }
        return 0;
    }

    public void deleteHand() {
        this.hand.clear();
    }
}
