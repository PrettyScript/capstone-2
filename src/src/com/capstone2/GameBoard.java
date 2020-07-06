package com.capstone2;

import java.util.Arrays;

public class GameBoard implements IDrawable {

    private Player player;
    private Chips chips;
    private String[][] gameBoard = new String[6][7];


    @Override
    public void drawBoard() {

        initializeGameBoard();

        gameBoard[5][1] = "T";
        gameBoard[0][0] = "T";
        gameBoard[3][3] = "Z";

        System.out.println("=========================================================");
        System.out.println("|  [1]  |  [2]  |  [3]  |  [4]  |  [5]  |  [6]  |  [7]  |");
        System.out.println("=========================================================");

        String board = "";

        for(String[] row: gameBoard){
            board += printRow(row);
            board += "=========================================================\n";
        }
        System.out.println(board);

    }

    private void initializeGameBoard()  {
        for(String[] row: gameBoard){
            Arrays.fill(row, " ");
        }
    }

    private String formatEntry(String entry){
        return "   "+entry+"   |";
    }

    private String printRow(String[] row) {
        return "|"
                +formatEntry(row[0])
                +formatEntry(row[1])
                +formatEntry(row[2])
                +formatEntry(row[3])
                +formatEntry(row[4])
                +formatEntry(row[5])
                +formatEntry(row[6])
                + "\n";
    }

}
