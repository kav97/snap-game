package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class CardGame {

    private static final ArrayList<Card> deckOfCards = new ArrayList<>();

    public CardGame() {
        for ( int i = 1; i <= 4; i++ ) {
            String suit;
            String symbol;
            if ( i == 1 ) {
                suit = "\u2665";    // hearts
            } else if ( i == 2 ) {
                suit = "\u2660";    // spades
            } else if ( i == 3 ) {
                suit = "\u25C6";    // diamonds
            } else {
                suit = "\u2663";    // clubs
            }
            for ( int j = 2; j <= 14; j++ ) {
                if ( j <= 10 ) {
                    symbol = String.valueOf(j);
                } else if ( j == 11 ) {
                    symbol = "J";
                } else if ( j == 12 ) {
                    symbol = "Q";
                } else if ( j == 13 ) {
                    symbol = "K";
                } else {
                    symbol = "A";
                }
                deckOfCards.add( new Card( suit, symbol, j ) );
            }
        }
    }

    public static ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public Card dealCard() {
        return deckOfCards.remove( deckOfCards.size() - 1 );
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        deckOfCards.sort( ( a, b ) -> a.getValue() - b.getValue() );
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort( ( a, b ) -> a.getSuit().compareTo( b.getSuit() ) );
        return deckOfCards;
    }

    public static ArrayList<Card> shuffleDeck() {
        Collections.shuffle( deckOfCards );
        return deckOfCards;
    }

    public static void getMessage( String message ) {
        System.out.println( message );
    }

}
