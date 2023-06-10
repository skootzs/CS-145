// Gabriella Samantha
// 05/20/2023
// CS 145
// Assignment 1 - Word Seach Generator
// Class - GSMWordSearch

import java.util.*;
import java.io.*;

public class GSMWordSearch {
    private char[][] grid;
    private boolean[][] sol;
    private String[] userWords;
    //Accepts a parameter of a string array and generates a new word search from this array.

    public void generate(String[] w) {

        for (int i = 0; i < w.length; i++) {
            w[i] = w[i].toLowerCase();
        }
        this.userWords = w;
        char[][] wordChars = setupGrid();
        for (int i = 0; i < wordChars.length; i++) {
            placeWord(wordChars, i);
        }
        fillGrid();
    }

    //To string
    //return: String

    public String toString() {

        String result = "";
        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[i].length; x++) {
                result += " " + grid[i][x] + " ";
            }
            result += "\r\n";
        }
        return result;
    }
    //Returns a string representation of the word searches solution.

    //To solution
    //return: String

    public String toSolution() {

        String result = "";
        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[i].length; x++) {
                if (sol[i][x]) {
                    result += " " + grid[i][x] + " ";
                } else {
                    result += " X "; //Places an "X" where ever the user given words are not placed

                }
            }
            result += "\r\n";
        }
        return result;
    }
    //Places a word in the word search grid. Determines the direction of the word and finds a valid place.

    //Place word
    //parameter: wordChars  the word chars
    //parameter: iter  the iter

    private void placeWord(char[][] wordChars, int iter) {

        Random rand = new Random();
        int direction = rand.nextInt(3);
        int[] pos = {
            0,
            0
        };
        if (direction == 0) { //horizontal
            boolean placed = false;
            int attempts = 0;
            while (!placed && attempts < 100) {
                pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
                pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
                placed = true;
                for (int u = 0; u < wordChars[iter].length; u++) {
                    if (grid[pos[0] + u][pos[1]] != '\u0000' && grid[pos[0] + u]
                        [pos[1]] != wordChars[iter][u]) { //Randomly places letters of the alphabet were the user word is not placed
                        placed = false;
                        break;
                    }
                }
                attempts++;
            }
            if (placed) {
                for (int x = 0; x < wordChars[iter].length; x++) {
                    grid[pos[0]][pos[1]] = wordChars[iter][x];
                    sol[pos[0]][pos[1]] = true;
                    pos[0]++;
                }
            }
        } else if (direction == 1) { //vertical
            boolean placed = false;
            int attempts = 0;
            while (!placed && attempts < 100) {
                pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
                pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
                placed = true;
                for (int u = 0; u < wordChars[iter].length; u++) {
                    if (grid[pos[0]][pos[1] + u] != '\u0000' && grid[pos[0]][pos[1] +
                            u
                        ] != wordChars[iter][u]) {
                        placed = false;
                        break;
                    }
                }
                attempts++;
            }
            if (placed) {
                for (int x = 0; x < wordChars[iter].length; x++) {
                    grid[pos[0]][pos[1]] = wordChars[iter][x];
                    sol[pos[0]][pos[1]] = true;
                    pos[1]++;
                }
            }
        } else if (direction == 2) { //diagonal
            boolean placed = false;
            int attempts = 0;
            while (!placed && attempts < 100) {
                pos[0] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
                pos[1] = rand.nextInt((grid.length - 1) - wordChars[iter].length);
                placed = true;
                for (int u = 0; u < wordChars[iter].length; u++) {
                    if (grid[pos[0] + u][pos[1] + u] != '\u0000' && grid[pos[0] + u]
                        [pos[1] + u] != wordChars[iter][u]) {
                        placed = false;
                        break;
                    }
                }
                attempts++;
            }
            if (placed) {
                for (int x = 0; x < wordChars[iter].length; x++) {
                    grid[pos[0]][pos[1]] = wordChars[iter][x];
                    sol[pos[0]][pos[1]] = true;
                    pos[1]++;
                    pos[0]++;
                }
            }
        }
    }
    //Breaks up the string array into a 2d char array and adjusts the size of the grid based on the
    //length and number of the userWords.

    //Setup grid
    //return: char[][]

    private char[][] setupGrid() {

        char[][] wordChars = new char[userWords.length][];
        int longest = 8;
        for (int i = 0; i < userWords.length; i++) {
            wordChars[i] = userWords[i].toCharArray();
            if (wordChars[i].length > longest) {
                longest = wordChars[i].length;
            }
        }
        if (userWords.length > longest) {
            longest = userWords.length;
        }
        this.grid = new char[longest + 4][longest + 4];
        this.sol = new boolean[longest + 4][longest + 4];
        return wordChars;
    }
    //Fills the grid with random characters in all of the empty indeces.
    //Fills in any remaining empty cells in the grid with random letters from the alphabet.
    //This method is called after all user-given words have been placed on the grid.
    //Fill grid
    private void fillGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid[i].length; x++) {
                Random rand = new Random();
                if (grid[i][x] == '\u0000') {
                    grid[i][x] = (char)(rand.nextInt(26) + 97);
                }
            }
        }
    }
}