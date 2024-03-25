import java.util.Scanner;

public class TicTacToe {
    static char board[][] = new char[3][3];

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        // making empty column

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                board[row][col] = ' ';
            }
        }

        // on game
        char player = 'X';
        boolean gameOver = false;
        int count = 0;
        while (!gameOver) {
            if (count == 10) {
                System.out.print("Game draw!");
                break;
            }
            printboard();
            System.out.println("Player " + player + " Make the move: ");
            int row = input.nextInt();
            int col = input.nextInt();
            System.out.println("");
            try {
                if (board[row][col] == ' ') {
                    board[row][col] = player;
                    count++;
                    if (hasWon(board, player)) {
                        System.out.println("Player " + player + " has won the game!");
                        gameOver = true;
                        break;
                    } else {
                        player = (player == 'X') ? 'O' : 'X';
                    }
                } else {

                    System.out.println("Invalid move! Try again");
                }
            } catch (Exception e) {
                System.out.println("Invalid move! Try again");
            }

        }
    }

    public static boolean hasWon(char board[][], char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        return false;
    }

    public static void printboard() {
        for (int row = 0; row < board.length; row++) {
            System.out.print("-------------\n| ");
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("");
        }
        System.out.println("-------------");
    }
}