package com.capstone2;

import java.util.Arrays;

public class GameBoard implements IDrawable {

    private Player player;
    private Chip chip;
    private String[][] gameBoard = new String[6][7];


    @Override
    public void drawBoard() {

//        initializeGameBoard();
//
//        gameBoard[5][1] = "X";
//        gameBoard[0][0] = "O";
//        gameBoard[3][3] = "X";
//
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

    public void initializeGameBoard()  {
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



    public void updateBoard(Player player, int choice) {
     // take in players column choice
     // loop through board rows to see if there is already a chip there
        // subtracting 1 from choice, to match the zero based array
        choice--;
        for(int i=gameBoard.length-1; i> 0; i--) {
            if(gameBoard[i][choice].equals(" ")) {
                gameBoard[i][choice] = player.getChip().getName();
                break;
            }
        }

        drawBoard();

    }

}
