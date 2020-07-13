package com.capstone2.connectfour.game;

public abstract class Game {

    abstract void initializeGameBoard();

    abstract void checkState(Player player) throws Exception;

    void gameOver() {
    }

    void gameOver(Player player) {

    }
}

