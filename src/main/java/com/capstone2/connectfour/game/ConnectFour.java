package com.capstone2.connectfour.game;


import java.util.Arrays;

public class ConnectFour extends Game implements IDrawable {

    private static ConnectFour game;
    private Player player;
    private Chip chip;
    private final String[][] gameBoard = new String[6][7];
    private int player1;
    private int player2;
    private int gameMoves;

    public boolean gameOver;
    public boolean playerRedo;
    public Player playerTurn;

    public ConnectFour() {}
    public static ConnectFour getInstance() {
        if(game == null) {
            game = new ConnectFour();
        }

        return game;
    }


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
        gameOver = false;
        playerRedo = false;
        player1 = 0;
        player2 = 0;
        gameMoves = 0;
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

    public String updateBoard(Player player, int choice) throws Exception {
        // subtracting 1 from choice, to match the zero based array
        choice--;
        String chipPosition = "";
        try {
            for (int i = gameBoard.length - 1; i >= 0; i--) {
                if (gameBoard[i][choice].equals(" ")) {
                    gameBoard[i][choice] = player.getChip().getName();
                    chipPosition = i + "-" + choice;
                    gameMoves++;
                    this.playerRedo = false;
                    break;
                } else if(i == 0) {
                    System.out.println("Sorry there are no available slots in this column, " +
                            "please try again");
                    this.playerRedo = true;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Sorry, please enter a valid number to continue playing.");
            this.playerRedo = true;
        }

        if(gameMoves >= 42) {
            gameOver();
        }

        drawBoard();
        checkState(player);
        return chipPosition;
    }

    protected void checkState(Player player) throws Exception {
        checkHorizontal(player);
        checkVertical(player);
        checkDiagonals(player, 1);
        checkDiagonals(player, -1);
    }

    private void checkHorizontal(Player player) throws Exception  {
        for(int i=gameBoard.length-1; i>= 0; i--) {

            for(int j=gameBoard[i].length-1; j>= 0; j--) {
                try {
                    if(gameBoard[i][j].contains("X")) {

                        player1++;

                        if(player1 == 4) {
                            gameOver(player);
                        }

                    } else {
                        player1 = 0;
                    }

                    if(gameBoard[i][j].contains("O")) {
                        player2++;
                        if(player2 == 4) {
                            gameOver(player);
                        }
                    } else {
                        player2 = 0;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored){}
            }
        }
    }

    private void checkVertical(Player player) throws Exception {
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
                } catch (ArrayIndexOutOfBoundsException ignored){}
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
                } catch (ArrayIndexOutOfBoundsException ignored){}
            }
        }
    }

    public void gameOver(Player player) {
        this.gameOver = true;
        System.out.println("Game over. " + player.getName() + " has won!");

    }

    public void gameOver() {
        this.gameOver = true;
        System.out.println("No one won!");
    }

}
