package com.capstone2;

public abstract class Game {

    abstract void initializeGameBoard();

    abstract void checkState(Player player) throws Exception;

    void gameOver() {
        System.out.println("No one won!");
    }

    void gameOver(Player player) {
        System.out.println("Game over. " + player.getName() + " has won!");
    }
}
