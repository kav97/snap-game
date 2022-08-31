package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGame {

    private final ArrayList<Card> deckOfCards = new ArrayList<>();
    private final static String[] suit = {"\u2665", "\u2663", "\u2666", "\u2660"};

    private final static String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private final static int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    Scanner scanner = new Scanner( System.in );


    public CardGame() {
        for (String s : suit) {
            for (int j = 0; j < values.length; j++) {
                Card card = new Card(s, symbols[j], values[j]);
                deckOfCards.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public Card dealCard() {
        return deckOfCards.remove( deckOfCards.size() - 1 );
    }

    public List<Card> sortDeckInNumberOrder() {
        deckOfCards.sort( ( a, b ) -> a.getValue() - b.getValue() );
        return deckOfCards;
    }

    public List<Card> sortDeckIntoSuits() {
        deckOfCards.sort( ( a, b ) -> a.getSuit().compareTo( b.getSuit() ) );
        return deckOfCards;
    }

    public void shuffleDeck() {
        Collections.shuffle( deckOfCards );
    }

    public String userInput() {
        return scanner.nextLine();
    }

    public void getMessage( String message ) {
        System.out.println( message );
    }
}
