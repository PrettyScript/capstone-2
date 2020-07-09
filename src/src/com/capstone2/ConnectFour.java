package com.capstone2;

import java.util.Arrays;

public class ConnectFour extends Game implements IDrawable {

    private Player player;
    private Chip chip;
    private final String[][] gameBoard = new String[6][7];
    private int player1 = 0;
    private int player2 = 0;
    private int gameMoves = 0;

    public boolean gameOver = false;
    public boolean playerRedo = false;
    public Player playerTurn;


    @Override
    public void drawBoard() {

        System.out.println("=========================================================");
        System.out.println("|  [1]  |  [2]  |  [3]  |  [4]  |  [5]  |  [6]  |  [7]  |");
        System.out.println("=========================================================");

        StringBuilder board = new StringBuilder();

        Arrays.stream(gameBoard).forEach(row ->
        {
            board.append(printRow(row));
            board.append("=========================================================\n");
        });
        System.out.println(board);

    }

    @Override
    public void initializeGameBoard()  {
        Arrays.stream(gameBoard).forEach(row -> Arrays.fill(row, " "));
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

    public void updateBoard(Player player, int choice) throws Exception {
        // subtracting 1 from choice, to match the zero based array
        choice--;
        try {
            for (int i = gameBoard.length - 1; i >= 0; i--) {
                if (gameBoard[i][choice].equals(" ")) {
                    gameBoard[i][choice] = player.getChip().getName();
                    gameMoves++;
                    break;
                } else if(i == 0) {
                    System.out.println("Sorry there are no available slots in this column, " +
                            "please wait your turn to try again");
                    this.playerRedo = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Sorry, please enter a valid number to continue playing.");
        }

        if(gameMoves >= 42) {
            gameOver();
        }

        drawBoard();
        checkState(player);
    }

    protected void checkState(Player player) throws Exception {
        checkHorizontal(player);
        checkVertical(player);
        checkDiagonals(player, 1);
        checkDiagonals(player, -1);

    }

    private void checkHorizontal(Player player) throws Exception  {
        for(int i=gameBoard.length-1; i>= 0; i--) {

            int playerOneCount = 0;
            int playerTwoCount = 0;

            for(int j=gameBoard[i].length-1; j>= 0; j--) {
                try {
                    if(gameBoard[i][j].contains("X")) {

                        playerOneCount++;

                        if(playerOneCount == 4) {
                            System.out.println("Check Horizontal Player X Won");
                            gameOver(player);
                        }

                    } else {
                        playerOneCount = 0;
                    }

                    if(gameBoard[i][j].contains("O")) {
                        playerTwoCount++;
                        if(playerTwoCount == 4) {
                            System.out.println("Check Horizontal Player O Won");
                            gameOver(player);
                        }
                    } else {
                        playerTwoCount = 0;
                    }
                } catch (Exception e){
//                    System.out.println("error");
                }
            }
        }
    }

    public void checkVertical(Player player) throws Exception {
        for (int i = gameBoard[0].length - 1; i >= 0; i--) {
            for (int j = gameBoard.length - 1; j >= 0; j--) {
                try {
                    if (gameBoard[j][i].contains("X")) {
                        player1++;

                        if(player1 == 4) {
                            gameOver(player);
                        }
                    } else {
                        player1 = 0;
                    }

                    if (gameBoard[j][i].contains("O")) {
                        player2++;

                        if(player2 == 4) {
                            gameOver(player);
                        }
                    } else {
                        player2 = 0;
                    }
                } catch (Exception e) {
//                    System.out.println("error");
                }
            }
        }
    }

    private void checkDiagonals (Player player, int direction) throws Exception {
        for (int i = gameBoard.length - 1; i >= 0; i--) {
            for (int j = gameBoard[i].length - 1; j >= 0; j--) {
                try {
                    if( gameBoard[i][j].contains("X") &&
                            gameBoard[i-1][j + (1 * direction)].contains("X") &&
                            gameBoard[i-2][j + (2 * direction)].contains("X") &&
                            gameBoard[i-3][j + (3 * direction)].contains("X")
                    ) {
                        gameOver(player);
                    }

                    if( gameBoard[i][j].contains("O") &&
                            gameBoard[i-1][j + (1 * direction)].contains("O") &&
                            gameBoard[i-2][j + (2 * direction)].contains("O") &&
                            gameBoard[i-3][j + (3 * direction)].contains("O")
                    ) {
                        gameOver(player);
                    }
                } catch (Exception e) {
//                    System.out.println("error");
                }
            }
        }
    }

    public void gameOver(Player player) {
        this.gameOver = true;
    }

    public void gameOver() {
        this.gameOver = true;
        // cat game: 1,1,2,4,3,3,2,2,1,2,1,1,2,1,3,2,3,3,4,3,4,4,5,4,4,5,5,1,5,5,6,5,6,6,7,6,6,7,7,6,7,7,5,
    }

}
