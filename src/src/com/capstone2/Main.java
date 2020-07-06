package com.capstone2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Player playerOne = new Player("Jessica");
        Player playerTwo = new Player("Hugh");

        Scanner scanner = new Scanner(System.in);


        System.out.print("Player one enter name: ");
        String player1Name = scanner.nextLine();
        playerOne.setName(player1Name);

        System.out.print("Player two enter name: ");
        String player2Name = scanner.nextLine();
        playerTwo.setName(player2Name);

        System.out.println("Welcome " + playerOne.getName() + " & " + playerTwo.getName());

        GameBoard game = new GameBoard();
        game.drawBoard();
    }
}
