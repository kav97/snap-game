package org.example;

/*Use the methods in card game and some new methods being in snap class
* to enable the user to play the game snap according to the following rules:
* Pressing enter into the command line for user to take turn
* Each turn a new card is dealt from the deck
* game continues until 2 cards have the same symbol, at which the player wins*/

import java.util.Scanner;

public class Snap extends CardGame {

    public Scanner getScanner() {

        Scanner scanner = new Scanner(System.in);
        return scanner;

    }

    public void runGame() {
        boolean isRunning = true;

        CardGame cardGame = new CardGame();

        System.out.println("Press enter to deal card ");


        getDeck();
        Card previousCard = null;

        while(isRunning){

            String inputData = getScanner().nextLine();
            int value = inputData.length();

            if (value == 0) {
                Card dealCard = cardGame.dealCard();
                System.out.println(dealCard);

                if(previousCard != null){
                    if(cardGame.compareCard(previousCard, dealCard)){
                        System.out.println("you win ");
                        isRunning = false;
                    }
                }

                previousCard = dealCard;

            }
        }

    }


    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.runGame();
    }

}
