// Gabriella Samantha Maria
// 05/31/2023
// CS 145
// Lab 6 - 20 Questions
// Class- QuestionTree

import java.io.PrintStream;
import java.util.Scanner;
public class QuestionTree {
    private QuestionNode overallRoot;
    private UserInterface ui;
    private int numGames;
    private int gamesWon;

    public QuestionTree(UserInterface ui) {
        this.ui = ui;
        overallRoot = new QuestionNode("computer");
        this.numGames = 0;
        this.gamesWon = 0;
    }
    /**
     * Calls a private helper method play to start playing the game
     */
    public void play() {
        numGames++;
        overallRoot = play(overallRoot);
    }
/**
 * Initiates a game. User asked yes/no questions until the computer wins or needs help guessing.
 * @param root Root node
 * @return Question node
 */    
 
        private QuestionNode play(QuestionNode root) {
        String response;
        if (root.left != null && root.right != null) {
            ui.println(root.data);
            // question
            response = ui.nextLine();
            if (response.equalsIgnoreCase("yeah") || response.equalsIgnoreCase("yep") ||
                response.equalsIgnoreCase("yes!") || response.equalsIgnoreCase("okay") ||
                response.equalsIgnoreCase("ok") || response.equalsIgnoreCase("of course") ||
                response.equalsIgnoreCase("yes please") || response.equalsIgnoreCase("y")) {
                root.left = play(root.left);
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("nope") ||
                response.equalsIgnoreCase("nah") || response.equalsIgnoreCase("no thank you") ||
                response.equalsIgnoreCase("no thx")) {
                root.right = play(root.right);
            }
        } else {
            ui.println("Would your object happen to be " + root.data +
                "?");
            response = ui.nextLine();
            if (response.equalsIgnoreCase("yeah") || response.equalsIgnoreCase("yep") ||
                response.equalsIgnoreCase("yes!") || response.equalsIgnoreCase("okay") ||
                response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("ok") || 
                response.equalsIgnoreCase("of course") ||response.equalsIgnoreCase("yes please") || 
                response.equalsIgnoreCase("y")) {
                ui.println("I win!");
                gamesWon++;
            } else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("nope") ||
                response.equalsIgnoreCase("nah") || response.equalsIgnoreCase("no thank you") ||
                response.equalsIgnoreCase("no") ||response.equalsIgnoreCase("no thx")) {
                ui.println("I lose. What is your object? ");
                String object = ui.nextLine();
                ui.println("Please give me a yes/no question that\n" +
                    "distinguishes between your object\n" +
                    "and mine--> ");
                String question = ui.nextLine();
                root.data = question;
                ui.println("And what is the answer for your object? (y/n)");
                response = ui.nextLine();
                if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                    root.left = new QuestionNode(object);
                    root.right = new QuestionNode(root.data);
                } else {
                    root.left = new QuestionNode(root.data);
                    root.right = new QuestionNode(object);
                }
                ui.println("Thanks!");
            }
        }
        return root;
    }

   /*
   * Uses a helper to save the output file.
   * @param output the output
   */
    public void save(PrintStream output) {
        save(output, overallRoot);
    }
    /**
    Saves the tree to output, with lines prefixed by Q/A for question/answer.
    @param output, root
    */    
    
    private void save(PrintStream output, QuestionNode root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                ui.println("Q:" + root.data);
                output.println("Q:" + root.data);
                save(output, root.left);
                save(output, root.right);
            } else {
                ui.println("A:" + root.data);
                output.println("A:" + root.data);
            }
        }
    }
    /**
    Invokes private method 'load' to read tree from a file.
    @param input file input
     */ 
     public void load(Scanner input) {
        overallRoot = load(input, overallRoot);
    }
    
    /**
    Reads a new tree from a file, replacing the existing one.
    @param input the input
    @return the updated node
    */    
    private QuestionNode load(Scanner input, QuestionNode current) {
        if (input.hasNextLine()) {
            String line = input.nextLine();
            current = new QuestionNode(line);
            // check for a Q or A
            char responseType = line.charAt(0);
            if (current != null) {
                if (responseType == 'Q') {
                    line = line.substring(2, line.length());
                    current.left = load(input, current);
                    current.right = load(input, current);
                }
            }
        }
        return current;
    }
    // Gets total games played count
    
    public int totalGames() {
        return numGames;
    }
    // Fetches the total count of games won
    
    public int gamesWon() {
        return gamesWon;
    }
}