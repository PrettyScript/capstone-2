package com.capstone2;

import java.util.Arrays;

public class GameBoard implements IDrawable {

    private Player player;
    private Chip chip;
    private String[][] gameBoard = new String[6][7];
    private int player1 = 0;
    private int player2 = 0;


    @Override
    public void drawBoard() {

//        gameBoard[1][0] = "X";
//        gameBoard[0][3] = "X";
//        gameBoard[0][4] = "X";
//        gameBoard[0][5] = "X";
//        gameBoard[0][6] = "X";
//        gameBoard[2][2] = "X";
//        gameBoard[0][2] = "X";

        gameBoard[3][1] = "X";
        gameBoard[2][2] = "X";
        gameBoard[3][1] = "X";
        gameBoard[1][3] = "X";

        gameBoard[4][5] = "O";
        gameBoard[3][4] = "O";
        gameBoard[2][3] = "O";

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

    public void checkState() {
        // check on which player won
        // 4 in a row, up, down, and diagonal
        // if player chip is the same 4 times then end the game

    }

    public void checkHorizontal() throws Exception  {
        for(int i=gameBoard.length-1; i>= 0; i--) {

            int playerOneCount = 0;
            int playerTwoCount = 0;

            for(int j=gameBoard[i].length-1; j>= 0; j--) {
//                System.out.println("("+(i+1)+","+(j+1)+"): "+gameBoard[i][j]);
                try {
                    if(gameBoard[i][j].contains("X")) {

                        playerOneCount++;

                        if(playerOneCount == 4) {
                            gameOver(new Player(new Chip("X")));
                        }

                    } else {
                        playerOneCount = 1;
                    }

                    if(gameBoard[i][j].contains("O")) {
                        playerTwoCount++;
                        if(playerTwoCount == 4) {
                            gameOver(new Player(new Chip("O")));
                        }
                    } else {
                        playerTwoCount = 1;
                    }
                } catch (Exception e){
//                    System.out.println("error");

                }
            }
        }

//        System.out.println("\uD83D\uDE00");
    }

    public void checkVertical() throws Exception {
        for (int i = gameBoard[0].length - 1; i >= 0; i--) {

            for (int j = gameBoard.length - 1; j >= 0; j--) {

                System.out.println((j+1) + " : " + gameBoard[j][i]);
                try {
                    if (gameBoard[j][i].contains("X")) {
                        player1++;

                        if(player1 == 4) {
                            gameOver(new Player(new Chip("X")));
                        }
                    } else {
                        player1 = 0;
                    }

                    if (gameBoard[j][i].contains("O")) {
                        player2++;

                        if(player2 == 4) {
                            gameOver(new Player(new Chip("O")));
                        }
                    } else {
                        player2 = 0;
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
    }

    public void checkDiagonals (int direction) throws Exception {
//        checkRightDiagonal();
//        checkLeftDiagonal();

        for (int i = gameBoard.length - 1; i >= 0; i--) {
            for (int j = gameBoard[i].length - 1; j >= 0; j--) {
                try {
                    if( gameBoard[i][j].contains("X") &&
                            gameBoard[i-1][j + (1 * direction)].contains("X") &&
                            gameBoard[i-2][j + (2 * direction)].contains("X") &&
                            gameBoard[i-3][j + (3 * direction)].contains("X")
                    ) {
                        gameOver(new Player(new Chip("X")));
                    }

                    if( gameBoard[i][j].contains("O") &&
                            gameBoard[i-1][j + (1 * direction)].contains("O") &&
                            gameBoard[i-2][j + (2 * direction)].contains("O") &&
                            gameBoard[i-3][j + (3 * direction)].contains("O")
                    ) {
                        gameOver(new Player(new Chip("O")));
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
    }

    public void checkRightDiagonal() {
        for (int i = gameBoard.length - 1; i >= 0; i--) {
            for (int j = gameBoard[i].length - 1; j >= 0; j--) {
                try {
                    if( gameBoard[i][j].contains("X") &&
                        gameBoard[i-1][j+1].contains("X") &&
                        gameBoard[i-2][j+2].contains("X") &&
                        gameBoard[i-3][j+3].contains("X")
                    ) {
                        gameOver(new Player(new Chip("X")));
                    }

                    if( gameBoard[i][j].contains("O") &&
                            gameBoard[i-1][j+1].contains("O") &&
                            gameBoard[i-2][j+2].contains("O") &&
                            gameBoard[i-3][j+3].contains("O")
                    ) {
                        gameOver(new Player(new Chip("O")));
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
    }

    public void checkLeftDiagonal() {
        for (int i = gameBoard.length - 1; i >= 0; i--) {
            for (int j = gameBoard[i].length - 1; j >= 0; j--) {
                try {
                    if( gameBoard[i][j].contains("X") &&
                            gameBoard[i-1][j-1].contains("X") &&
                            gameBoard[i-2][j-2].contains("X") &&
                            gameBoard[i-3][j-3].contains("X")
                    ) {
                        gameOver(new Player(new Chip("X")));
                    }

                    if( gameBoard[i][j].contains("O") &&
                            gameBoard[i-1][j-1].contains("O") &&
                            gameBoard[i-2][j-2].contains("O") &&
                            gameBoard[i-3][j-3].contains("O")
                    ) {
                        gameOver(new Player(new Chip("O")));
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
    }


    public void gameOver(Player player) {
        System.out.println("Game over. " + player.getChip().getName() + " has won!");
    }

    public void gameOver() {
        System.out.println("No one won!");
    }

}
