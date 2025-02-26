package csc223.tc;

import java.util.Scanner;

public class TicTacToe implements Game {

    private char[] locations = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    // private String[] boardPrint = {
    // " 1 | 2 | 3 ",
    // "---|---|---",
    // " 4 | 5 | 6 ",
    // "---|---|---",
    // " 7 | 8 | 9 "
    // };
    private String[] board = {
            " " + this.locations[0] + " | " + this.locations[1] + " | " + this.locations[2]
                    + " \n" + "---|---|---\n" +
                    " " + this.locations[3] + " | " + this.locations[4] + " | " + this.locations[5]
                    + " \n" + "---|---|---\n" +
                    " " + this.locations[6] + " | " + this.locations[7] + " | " + this.locations[8]
    };
    // first three are blank priority moves for blocking wins
    private char[] AImoves = { ' ', ' ', ' ', '5', '1', '3', '7', '9', '2', '4', '6', '8', '1' };
    private int TurnsTaken;
    private int maxTurns;

    public void startGame() {
        System.out.println("You are: O");
        System.out.println("They are: X");
        System.out.println("");
        this.locations = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        this.TurnsTaken = 0;
        this.maxTurns = 6;
    }

    public void printBoard() {
        this.board = new String[] {
                " " + this.locations[0] + " | " + this.locations[1] + " | " + this.locations[2] + " \n" +
                        "---------\n" +
                        " " + this.locations[3] + " | " + this.locations[4] + " | " + this.locations[5] + " \n" +
                        "---------\n" +
                        " " + this.locations[6] + " | " + this.locations[7] + " | " + this.locations[8] + " "
        };
        for (int i = 0; i < this.board.length; i++) {
            System.out.println(this.board[i]);
        }
    }

    public void takeTurn() {
        // player turn
        Scanner input = new Scanner(System.in);
        System.out.print("Choose location: ");
        String in = input.next();
        char location = in.charAt(0);
        for (int i = 0; i < this.locations.length; i++) {
            if (location == (this.locations[i])) {
                this.locations[i] = 'O';
            }
        }
        this.TurnsTaken += 1;
        // AI turn (5,1,3)

        // AI win blocking (priority)
        // Horizontal win blocking (AI)
        if ((this.locations[0] == this.locations[1]) | (this.locations[1] == this.locations[2])
                | (this.locations[0] == this.locations[2])
                && (!((this.locations[0] == 'X') | (this.locations[1] == 'X') | (this.locations[2] == 'X')))) {
            this.AImoves[0] = '1';
            this.AImoves[1] = '2';
            this.AImoves[2] = '3';
        }
        if (((this.locations[3] == this.locations[4]) | (this.locations[4] == this.locations[5])
                | (this.locations[3] == this.locations[5]))
                && (!((this.locations[3] == 'X') | (this.locations[4] == 'X') | (this.locations[5] == 'X')))) {
            this.AImoves[0] = '4';
            this.AImoves[1] = '5';
            this.AImoves[2] = '6';
        }
        if ((this.locations[6] == this.locations[7]) | (this.locations[7] == this.locations[8])
                | (this.locations[6] == this.locations[8])
                && (!((this.locations[6] == 'X') | (this.locations[7] == 'X') | (this.locations[8] == 'X')))) {
            this.AImoves[0] = '7';
            this.AImoves[1] = '8';
            this.AImoves[2] = '9';
        }
        // Vertical win blocking (AI)
        if ((this.locations[0] == this.locations[3]) | (this.locations[3] == this.locations[6])
                | (this.locations[0] == this.locations[6])
                && (!((this.locations[0] == 'X') | (this.locations[3] == 'X') | (this.locations[6] == 'X')))) {
            this.AImoves[0] = '1';
            this.AImoves[1] = '4';
            this.AImoves[2] = '7';
        }
        if ((this.locations[1] == this.locations[4]) | (this.locations[4] == this.locations[7])
                | (this.locations[1] == this.locations[7])
                && (!((this.locations[1] == 'X') | (this.locations[4] == 'X') | (this.locations[7] == 'X')))) {
            this.AImoves[0] = '2';
            this.AImoves[1] = '5';
            this.AImoves[2] = '8';
        }
        if ((this.locations[2] == this.locations[5]) | (this.locations[5] == this.locations[8])
                | (this.locations[2] == this.locations[8])
                && (!((this.locations[2] == 'X') | (this.locations[5] == 'X') | (this.locations[8] == 'X')))) {
            this.AImoves[0] = '3';
            this.AImoves[1] = '6';
            this.AImoves[2] = '9';
        }
        // Diaginal win blocking (AI)
        if ((this.locations[0] == this.locations[4]) | (this.locations[4] == this.locations[8])
                | (this.locations[0] == this.locations[8])
                && (!((this.locations[0] == 'X') | (this.locations[4] == 'X') | (this.locations[8] == 'X')))) {
            this.AImoves[0] = '1';
            this.AImoves[1] = '5';
            this.AImoves[2] = '9';
        }
        if ((this.locations[2] == this.locations[4]) | (this.locations[4] == this.locations[6])
                | (this.locations[2] == this.locations[6])
                && (!((this.locations[2] == 'X') | (this.locations[4] == 'X') | (this.locations[6] == 'X')))) {
            this.AImoves[0] = '3';
            this.AImoves[1] = '5';
            this.AImoves[2] = '7';
        }

        for (int p = 0; p < 3; p++) {
            System.out.print(" priority moves: " + this.AImoves[p]);
        }
        System.out.println();

        AiTurn: for (int j = 0; j < this.locations.length; j++) {
            for (int l = 0; l < this.locations.length; l++) {
                if (this.AImoves[j] == (this.locations[l])) {
                    this.locations[l] = 'X';
                    // resets priority moves
                    this.AImoves[0] = ' ';
                    this.AImoves[1] = ' ';
                    this.AImoves[2] = ' ';
                    break AiTurn;
                }
            }
        }
    }

    public boolean isGameOver() {

        // Horizontal win conditions
        if ((this.locations[0] == this.locations[1]) && (this.locations[1] == this.locations[2])) {
            if (this.locations[0] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        } else if ((this.locations[3] == this.locations[4]) && (this.locations[3] == this.locations[5])) {
            if (this.locations[3] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        } else if ((this.locations[6] == this.locations[7]) && (this.locations[6] == this.locations[8])) {
            if (this.locations[6] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        }

        // Verticle win conditions
        else if ((this.locations[0] == this.locations[3]) && (this.locations[0] == this.locations[6])) {
            if (this.locations[0] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        } else if ((this.locations[1] == this.locations[4]) && (this.locations[1] == this.locations[7])) {
            if (this.locations[1] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        } else if ((this.locations[2] == this.locations[5]) && (this.locations[2] == this.locations[8])) {
            if (this.locations[2] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        }

        // Diaginal win conditions
        else if ((this.locations[0] == this.locations[4]) && (this.locations[0] == this.locations[8])) {
            if (this.locations[0] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        } else if ((this.locations[2] == this.locations[4]) && (this.locations[2] == this.locations[6])) {
            if (this.locations[2] == 'O') {
                System.out.println("You Have Wone the Game!");
            } else {
                System.out.println("You Have Lost the Game");
            }
            return true;
        }

        // full board - turn counter
        if (this.TurnsTaken == this.maxTurns) {
            System.out.println("Tie");
            return true;
        }
        System.out.println("Turn: " + this.TurnsTaken);
        return false;
    }

    public void endGame() {
        printBoard();
        Scanner input = new Scanner(System.in);
        System.out.print("Game Over Continue? (Y/N): ");
        String Continue = input.nextLine();
        if (Continue.equals("Y")) {
            playGame();
        } else {
            input.close();
            System.exit(0);
        }
    }

    public void playGame() {
        startGame();
        while (!(isGameOver())) {
            printBoard();
            takeTurn();
        }
        endGame();
    }

    public static void main(String[] args) {

        TicTacToe Game = new TicTacToe();

        Game.playGame();
    }
}
