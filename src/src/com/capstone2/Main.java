package com.capstone2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        // 1, 2, 2, 3, 1, 3, 3, 4,

        startGame();

    }

    public static void startGame() throws Exception {
        Scanner scanner = new Scanner(System.in);
        GameBoard game = new GameBoard();

        game.initializeGameBoard();
        game.drawBoard();


        Player playerOne = new Player(new Chip("X"));
        Player playerTwo = new Player(new Chip("O"));

        System.out.print("Player one enter name: ");
        String player1Name = scanner.nextLine();
        playerOne.setName(player1Name);

        System.out.print("Player two enter name: ");
        String player2Name = scanner.nextLine();
        playerTwo.setName(player2Name);

        System.out.println("Welcome " + playerOne.getName() + " & " + playerTwo.getName());

        while(!game.gameOver) {

            playerTurn(playerOne, game);

            if(game.gameOver) {
                break;
            }

            playerTurn(playerTwo, game);

        }
    }

    public static void playerTurn(Player player, GameBoard game) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print(player.getName() + " turn: ");
        int choice = scanner.nextInt();
        game.updateBoard(player, choice);
    }
}


