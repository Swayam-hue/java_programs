import java.util.*;

public class tictactoe {

    static boolean haveWon(char[][]board, char player)
    {
        // for rows
        for (int row = 0; row < board.length; row++)
        {
            if (board[row][0] == player && board[row][1]== player && board[row][2] == player)
            {
                return true;
            }
        }

        // for columns
        for(int col = 0; col < board.length; col++)
        {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player)
            {
                return true;
            }
        } 

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
        return true;
        else if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
        return true;

        else
        return false;



    }

    static void printBoard(char[][]board)
    {
        int row, col;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        char[][] board = new char[3][3];
        int row, col;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner (System.in);

        while (!gameOver){
            printBoard(board);
            System.out.println("Player " + player + "enter : ");
            int row1 = sc.nextInt();
            int col1 = sc.nextInt();
             if (board[row1][col1] == ' ')
             {
                board[row1][col1] = player;
                gameOver = haveWon(board, player);
                if (gameOver)
                {
                    System.out.println("Player " + player + "has won.");
                }
                else
                {
                    if (player == 'X')
                    player = 'O';
                    else
                    player = 'X';
                }
             }
             else
             {
                System.out.println("Invalid move.");
             }
        }
        printBoard(board);

    }

}
