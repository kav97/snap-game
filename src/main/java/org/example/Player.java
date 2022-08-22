package org.example;

public class Player {

    private final String name;

    public Player( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTurn() {
        return "It's " + getName() + "'s turn:";
    }

    public String getWin() {
        return "SNAP!! You won " + getName() + "!!";
    }
}
