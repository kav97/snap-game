package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    private static final ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        for (int i = 1; i <= 4; i++) {
            String suit;
            String symbol;
            if (i == 1) {
                suit = "\u2665";    // hearts
            } else if (i == 2) {
                suit = "\u2660";    // spades
            } else if (i == 3) {
                suit = "\u25C6";    // diamonds
            } else {
                suit = "\u2663";    // clubs
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

    public Card dealCard() {
        return deckOfCards.remove(deckOfCards.size() - 1);
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        deckOfCards.sort((a, b) -> a.getValue() - b.getValue());
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        deckOfCards.sort( (a, b) -> a.getSuit().compareTo(b.getSuit()) );
        return deckOfCards;
    }

    public static ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

    public boolean compareCard (Card cardOne, Card cardTwo){
        String cardOneSymbol = cardOne.getSymbol();
        String cardTwoSymbol = cardTwo.getSymbol();
//        System.out.println(cardOneSymbol);
//        System.out.println(cardTwoSymbol);
//        boolean isSame = cardOneSymbol.equals(cardTwoSymbol);
//        System.out.println(isSame);
        return cardOneSymbol.equals(cardTwoSymbol);
    }


    public static void main(String[] args) {
        CardGame deck = new CardGame();

        System.out.println("retrieve deck:");
        deck.getDeck();
//        System.out.println("deal card:");
//        System.out.println(deck.dealCard());
//        System.out.println("sort deck by number:");
//        System.out.println(deck.sortDeckInNumberOrder());
//        System.out.println("sort deck by suit");
//        System.out.println(deck.sortDeckIntoSuits());
//        System.out.println("shuffle deck");
//        System.out.println(deck.shuffleDeck());
//        System.out.println("deal card:");
//        System.out.println(deck.dealCard());
//        deck.getDeck();


    }

}
