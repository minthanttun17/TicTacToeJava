import java.util.Scanner;

public class TicTacToe {

        public enum T{
            X,O,E;
        }

        static int playerOneScore = 0;
        static int playerTwoScore = 0;
        static boolean exit = false;
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            int currentPlayer = 1;
            boolean exit = false;
            T[][] board = new T[3][3];

            // Start game.....
            startGame(board); // init to empty cell
            displayBoard(board); // display numbers

            while(true){
                int row = 0;
                int col = 0;

                System.out.printf("Player %d turns. Enter number: ", currentPlayer);
                int userInput = input.nextInt();

                // user only need to type 1,2,3...
                switch (userInput){
                    case 1:
                        row = 0;
                        col = 0;
                        break;
                    case 2:
                        row = 0;
                        col = 1;
                        break;
                    case 3:
                        row = 0;
                        col = 2;
                        break;
                    case 4:
                        row = 1;
                        col = 0;
                        break;
                    case 5:
                        row = 1;
                        col = 1;
                        break;
                    case 6:
                        row = 1;
                        col = 2;
                        break;
                    case 7:
                        row = 2;
                        col = 0;
                        break;
                    case 8:
                        row = 2;
                        col = 1;
                        break;
                    case 9:
                        row = 2;
                        col = 2;
                        break;
                    default:
                        System.out.print("Invalid Number!");
                        break;
                }

                // change number to X or O.
                if (board[row][col].equals(T.E)) {
                    if(currentPlayer == 1){
                        board[row][col] = T.X;
                        displayBoard(board);
                        diaplyWinLoseDraw(board, currentPlayer, input);
                        if(exit){
                            break;
                        }
                        currentPlayer = 2; // next turn is player 2
                    } else {
                        board[row][col] = T.O;
                        displayBoard(board);
                        diaplyWinLoseDraw(board, currentPlayer, input);
                        if(exit){
                            break;
                        }
                        currentPlayer = 1;
                    }
                } else {
                    System.out.println("Cell is already occupied. Try again.");
                }
            }
        }
        // Display board
        public static void displayBoard(T[][] board) {
            int num = 1;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board[i][j] == T.E){
                        System.out.print(num);
                    } else {
                        System.out.print(board[i][j]);
                    }
                    num ++;
                    if(j != 2){
                        System.out.print(" | ");
                    }            }
                System.out.println();

                if(i != 2){
                    System.out.println("__________");
                }
            }
        }

        // Start or restart the game
        public static void startGame(T[][] board){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++) {
                    board[i][j] = T.E;
                }
            }
        }

        // check Win or Lose
        public static boolean winOrLose(T[][] board){
            if(
                    board[0][0] == T.X && board[0][1] == T.X && board[0][2] == T.X ||
                            board[0][0] == T.O && board[0][1] == T.O && board[0][2] == T.O ||
                            board[1][0] == T.O && board[1][1] == T.O && board[1][2] == T.O ||
                            board[1][0] == T.X && board[1][1] == T.X && board[1][2] == T.X ||
                            board[2][0] == T.O && board[2][1] == T.O && board[2][2] == T.O ||
                            board[2][0] == T.X && board[2][1] == T.X && board[2][2] == T.X ||
                            board[0][0] == T.O && board[1][0] == T.O && board[2][0] == T.O ||
                            board[0][0] == T.X && board[1][0] == T.X && board[2][0] == T.X ||
                            board[0][1] == T.O && board[1][1] == T.O && board[2][1] == T.O ||
                            board[0][1] == T.X && board[1][1] == T.X && board[2][1] == T.X ||
                            board[0][2] == T.O && board[1][2] == T.O && board[2][2] == T.O ||
                            board[0][2] == T.X && board[1][2] == T.X && board[2][2] == T.X ||
                            board[0][0] == T.O && board[1][1] == T.O && board[2][2] == T.O ||
                            board[0][0] == T.X && board[1][1] == T.X && board[2][2] == T.X ||
                            board[0][2] == T.O && board[1][1] == T.O && board[2][0] == T.O ||
                            board[0][2] == T.X && board[1][1] == T.X && board[2][0] == T.X
            ){
                return true;
            }
            return false;
        }

        // Check Draw
        public static boolean isDraw(T[][] board){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++) {
                    if(board[i][j] == T.E){
                        return false;
                    }
                }
            }
            return true;
        }

        public static void diaplyWinLoseDraw(T[][] board, int currentPlayer, Scanner input){

            if(winOrLose(board) == true && currentPlayer == 1){
                System.out.println("Player 1 wins!");
                playerOneScore++;
                System.out.print("You want to exit? (y/n): ");
                String i = input.next();
                if(i.equals("y") || i.equals("Y")){
                    System.out.printf("Player 1's Score: %d%n", playerOneScore);
                    System.out.printf("Player 2's Score: %d%n", playerTwoScore);
                    System.out.println("Thanks you for playing");
                } else {
                    System.out.printf("Player 1's Score: %d%n", playerOneScore);
                    System.out.printf("Player 2's Score: %d%n", playerTwoScore);
                    startGame(board);
                }
            } else if(winOrLose(board) == true && currentPlayer == 2){
                System.out.print("Player 2 wins!");
                playerTwoScore++;

                System.out.print("You want to exit? (y/n): ");
                String i = input.next();

                if(i.equals("y") || i.equals("Y")){
                    System.out.println("Thanks you for playing");
                    System.exit(0);
                } else {
                    System.out.printf("Player 1's Score: %d%n", playerOneScore);
                    System.out.printf("Player 2's Score: %d%n", playerTwoScore);
                    startGame(board);
                }
            } else if(isDraw(board)){
                System.out.println("Draw");
                System.out.printf("Player 1's Score: %d%n", playerOneScore);
                System.out.printf("Player 2's Score: %d%n", playerTwoScore);
                System.out.print("You want to exit? (y/n): ");
                String i = input.next();
                if(i.equals("y") || i.equals("Y")){
                    System.exit(0);
                    System.out.println("Thanks you for playing");
                } else {
                    startGame(board);
                    System.out.printf("Player 1's Score: %d%n", playerOneScore);
                    System.out.printf("Player 2's Score: %d%n", playerTwoScore);
                }
            }
        }
}