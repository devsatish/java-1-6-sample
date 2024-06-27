import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    Deck(Deck original) {
        this.deck = new ArrayList<>();

        for (int i = 0; i < original.getTotalCards(); i++) {
            var cardTemp = original.getCard(i);
            var deepCopy = new Card(cardTemp.getRank(), cardTemp.getSuit());
            this.deck.add(deepCopy);
        }
    }

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

    public int getTotalCards() {
        return deck.size();
    }

    /** Toma 100 pares de cartas y los cambia de lugar para revolver el deck. **/
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

    public Card dealCard() {
        return deck.remove(0);
    }

    public Card dealRandomCard() {
        var generator = new Random();
        var index = generator.nextInt(this.deck.size());
        var randomCard = deck.get(index);
        deck.remove(index);
        return randomCard;
    }

    public void removeCard(Card card) {
        deck.removeIf(c -> c.getRank() == card.getRank() && c.getSuit() == card.getSuit());
    }

    public void removeCards(String[] c) {
        for (var cardStr : c) {
            var temp = new Card(cardStr);
            deck.removeIf(card -> card.getRank() == temp.getRank() && card.getSuit() == temp.getSuit());
        }
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public void addCard(Card c) {
        this.deck.add(c);
    }

    public boolean containsCard(Card card) {
        return deck.contains(card);
    }

    public Card[] toArray() {
        return deck.toArray(new Card[0]);
    }

    public void clearDeck() {
        this.deck.clear();
    }
}
