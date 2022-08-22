package org.example;

/*Use the methods in card game and some new methods being in snap class
* to enable the user to play the game snap according to the following rules:
* Pressing enter into the command line for user to take turn
* Each turn a new card is dealt from the deck
* game continues until 2 cards have the same symbol, at which the player wins*/

import java.util.Scanner;

public class Snap extends CardGame {
    Scanner scanner = new Scanner( System.in );

    public boolean isCardsSuitMatching ( Card cardOne, Card cardTwo ) {
        String cardOneSymbol = cardOne.getSymbol();
        String cardTwoSymbol = cardTwo.getSymbol();
        return cardOneSymbol.equals(cardTwoSymbol);
    }

    public void runGame() {
        boolean isRunning = true;

        CardGame cardGame = new CardGame();

        System.out.println( "Press enter to deal card" );

        shuffleDeck();
        Card previousCard = null;

        while( isRunning ) {

            String inputData = scanner.nextLine();
            int value = inputData.length();

            if ( value == 0 ) {   // the game only deals a card if enter is pressed
                Card dealCard = cardGame.dealCard();
                System.out.println( dealCard );

                if( previousCard != null ) {
                    if( isCardsSuitMatching( previousCard, dealCard ) ) {
                        System.out.println( "SNAP!!!" );
                        isRunning = false;
                    }
                }

                previousCard = dealCard;
            }
        }
    }

    public static void main( String[] args ) {
        Snap snap = new Snap();
        snap.runGame();
    }
}
