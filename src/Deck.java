/**
 * @author scrub
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private ArrayList<Card> deck;

    Deck(Deck original) {
        this.deck = new ArrayList<>();

        original.deck.forEach(card_temp -> {
            Card deepCopy = new Card(card_temp.getRank(), card_temp.getSuit());
            this.deck.add(deepCopy);
        });
    }

    Deck() {
        this.deck = new ArrayList<>();

        IntStream.range(0, 4).forEach(suit -> 
            IntStream.range(0, 13).forEach(rank -> 
                this.deck.add(new Card(rank, suit))
            )
        );
    }

    @Override
    public String toString() {
        return deck.stream()
                   .map(Card::toString)
                   .collect(Collectors.joining());
    }

    public int getTotalCards() {
        return deck.size();
    }

    /** Toma 100 pares de cartas y los cambia de lugar para revolver el deck. **/
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

    public Card dealCard() {
        return deck.remove(0);
    }

    public Card dealRandomCard() {
        Random generator = new Random();
        int index = generator.nextInt(this.deck.size());
        return deck.remove(index);
    }

    public void removeCard(Card card) {
        deck.removeIf(c -> c.getRank() == card.getRank() && c.getSuit() == card.getSuit());
    }

    public void removeCards(String[] c) {
        for (String cardStr : c) {
            Card temp = new Card(cardStr);
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
