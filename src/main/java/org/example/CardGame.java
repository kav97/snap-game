package org.example;

import java.util.ArrayList;

public class CardGame {

    private static final ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        for (int i = 1; i <= 4; i++) {
            String suit;
            String symbol;
            if (i == 1) {
                suit = "\u2665";    // Hearts
            } else if (i == 2) {
                suit = "\u2660";    // Spades
            } else if (i == 3) {
                suit = "\u25C6";    // Diamonds
            } else {
                suit = "\u2663";    // Clubs
            }
            for (int j = 2; j <= 14; j++) {
                if (j <= 10) {
                    symbol = String.valueOf(j);
                } else if (j == 11) {
                    symbol = "J";
                } else if (j == 12) {
                    symbol = "Q";
                } else if (j == 13) {
                    symbol = "K";
                } else {
                    symbol = "A";
                }
                deckOfCards.add(new Card(suit, symbol, j));
            }
        }
    }

    public void getDeck() {
        for (Card card : deckOfCards) {
            System.out.println(card.toString());
        }
    }


    public static void main(String[] args) {
        CardGame deck = new CardGame();

        deck.getDeck();
    }

}
