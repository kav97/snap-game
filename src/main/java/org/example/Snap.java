package org.example;

import java.util.ArrayList;
import java.util.List;

public class Snap extends CardGame {

    private boolean isCardsSuitMatching ( Card cardOne, Card cardTwo ) {
        String cardOneSymbol = cardOne.getSymbol();
        String cardTwoSymbol = cardTwo.getSymbol();
        return cardOneSymbol.equals( cardTwoSymbol );
    }


    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();

        getMessage( "Enter player 1 name:" );
        Player playerOne = new Player( userInput() );
        players.add(playerOne);

        getMessage( "Enter player 2 name:" );
        Player playerTwo = new Player( userInput() );
        players.add(playerTwo);

        return players;
    }

    public void runGame() {

        List<Player> players = getPlayers();

        boolean isRunning = true;

        getMessage( "Press enter to deal card" );

        shuffleDeck();
        Card previousCard = null;

        int playerTurn = 0;

        while( isRunning ) {

            getMessage( players.get( playerTurn % 2 ).getTurn() );

            if ( userInput().length() == 0 ) {   // only deals a card if enter is pressed
                Card dealtCard = dealCard();
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
