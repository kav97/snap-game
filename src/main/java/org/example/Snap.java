package org.example;

import java.util.ArrayList;

public class Snap extends CardGame {

    public boolean isCardsSuitMatching ( Card cardOne, Card cardTwo ) {
        String cardOneSymbol = cardOne.getSymbol();
        String cardTwoSymbol = cardTwo.getSymbol();
        return cardOneSymbol.equals( cardTwoSymbol );
    }

    public ArrayList<Player> getPlayers() {
        getMessage( "Enter player 1 name:" );
        Player playerOne = new Player( userInput() );

        getMessage( "Enter player 2 name:" );
        Player playerTwo = new Player( userInput() );

        return new ArrayList<>()
        {
            {
                add( playerOne );
                add( playerTwo );
            }
        };
    }

    public void runGame() {

        ArrayList<Player> players = getPlayers();

        boolean isRunning = true;

        CardGame cardGame = new CardGame();

        getMessage( "Press enter to deal card" );

        shuffleDeck();
        Card previousCard = null;

        int playerTurn = 0;

        while( isRunning ) {

            getMessage( players.get( playerTurn % 2 ).getTurn() );

            if ( userInput().length() == 0 ) {   // only deals a card if enter is pressed
                Card dealtCard = cardGame.dealCard();
                System.out.println( dealtCard );

                if ( previousCard != null ) {
                    if ( isCardsSuitMatching( previousCard, dealtCard ) ) {
                        getMessage( players.get( playerTurn % 2 ).getWin() );
                        isRunning = false;
                    }
                }

                previousCard = dealtCard;
            }

            playerTurn++;
        }
    }

    public static void main( String[] args ) {
        Snap snap = new Snap();
        snap.runGame();
    }
}
