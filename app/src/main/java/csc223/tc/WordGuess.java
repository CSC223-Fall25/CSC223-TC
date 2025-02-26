package csc223.tc;

import java.util.Scanner;
import java.util.Arrays;

public class WordGuess implements Game {

    private int TurnsTaken;
    private int Turns;
    private char[] word;
    private char guess;
    private String[] words = { "CHICKEN", "ELECTRIC", "JAVA", "BUTTER", "SYNTAX", "COMPUTER" };
    private int wordidx = 0;
    private char[] wordGuess = { '_' };
    private char[] progress;

    public void startGame() {
        this.Turns = 5;
        this.TurnsTaken = 0;
        this.word = this.words[this.wordidx].toCharArray();
        this.wordidx += 1;
        this.guess = '_';
        this.progress = new char[this.word.length];
        for (int p = 0; p < this.word.length; p++) {
            this.progress[p] = '_';
        }
    }

    public void printBoard() {
        System.out.println("Turn: " + this.TurnsTaken + "/" + this.Turns);
        for (int j = 0; j < this.word.length; j++) {
            if (this.word[j] != this.guess) {
                if (this.word[j] == this.progress[j]) {
                    System.out.print(this.progress[j]);
                } else {
                    System.out.print('_');
                }
            } else {
                this.progress[j] = this.guess;
                System.out.print(this.progress[j]);
            }
        }
        System.out.println("");
    }

    public void takeTurn() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your Guess: ");
        this.wordGuess = input.nextLine().toCharArray();
        // premature exit
        if (this.wordGuess.length == 0) {
            System.exit(0);
        }
        if (this.wordGuess.length == 1) {
            this.guess = this.wordGuess[0];
        }
        this.TurnsTaken += 1;
        printBoard();
    }

    public boolean isGameOver() {
        if (this.wordGuess.length == this.word.length) {
            if (Arrays.equals(this.wordGuess, this.word)) {
                String e = new String(this.word);
                System.out.println("Congratulations You Have Won, The Word Was: " + e);
                return true;
            }
        }
        return this.TurnsTaken == this.Turns;
    }

    public void endGame() {
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
        printBoard();
        while (!(isGameOver())) {
            takeTurn();
        }
        endGame();
    }

    public static void main(String[] args) {

        WordGuess Game = new WordGuess();

        Game.playGame();
    }
}
