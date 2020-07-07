package com.capstone2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {


        Player playerOne = new Player(new Chip("X"));
        Player playerTwo = new Player(new Chip("O"));

//        System.out.println(playerOne.getChip().getName());


//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.print("Player one enter name: ");
//        String player1Name = scanner.nextLine();
//        playerOne.setName(player1Name);
//
//        System.out.print("Player two enter name: ");
//        String player2Name = scanner.nextLine();
//        playerTwo.setName(player2Name);
//
//        System.out.println("Welcome " + playerOne.getName() + " & " + playerTwo.getName());

        GameBoard game = new GameBoard();
        game.initializeGameBoard();
        game.drawBoard();
        game.updateBoard(playerOne, 3);
        game.updateBoard(playerTwo, 1);
        game.updateBoard(playerOne, 3);
        game.updateBoard(playerTwo, 7);
        game.updateBoard(playerOne, 1);
        game.updateBoard(playerTwo, 2);
        game.updateBoard(playerOne, 4);
        game.updateBoard(playerTwo, 6);
        game.updateBoard(playerOne, 7);
        game.updateBoard(playerTwo, 4);
        game.updateBoard(playerOne, 3);
        game.updateBoard(playerTwo, 5);

//        game.checkHorizontal();
//        game.checkVertical();

    }

    public void startGame() {
        boolean gameOver = true;
        while(!gameOver) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Player one turn: ");
            scanner.nextInt();

        }
    }
}
