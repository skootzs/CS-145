// Gabriella Samantha Maria
// 05/20/2023
// CS 145
// Assignment 1 - Word Search Generator
// Class - GSMWordSearchMain

import java.util.*;
import java.io.*;

public class GSMWordSearchMain {

    // Main method
    // Arguments: args
    // Exception: FileNotFoundException

    public static void main(String[] args) throws FileNotFoundException {

        boolean generated = false;
        Scanner console = new Scanner(System.in);
        String choice;
        GSMWordSearch search = new GSMWordSearch();
        do {
            displayWelcomeMessage();
            choice = console.next();
            if (choice.equals("g")) {
                System.out.println("Read words from file? (y/n)");
                String fileChoice = console.next();
                if (fileChoice.equals("y")) {
                    System.out.println("Enter the filename:");
                    String filename = console.next();
                    String[] words = fetchWordsFromFile(filename);
                    search.generate(words);
                    generated = true;
                } else {
                    System.out.println("Enter words line by line until you are finished at which point type a single \"q\"");
                    String tok = console.next();
                    ArrayList < String > wordGrid = new ArrayList < String > ();
                    do {
                        wordGrid.add(tok);
                        tok = console.next();
                    } while (!tok.equals("q"));
                    String[] words = new String[wordGrid.size()];
                    wordGrid.toArray(words);
                    search.generate(words);
                    generated = true;
                }
            } else if (choice.equals("p")) {
                if (generated) {
                    print(search);
                }
            } else if (choice.equals("s")) {
                if (generated) {
                    displaySolution(search);
                }
            }
        } while (!choice.equals("q"));
    }

    // Prints the initial greeting and instructions for the program.

    public static void displayWelcomeMessage() {

        System.out.println("Welcome to my word search generator!");
        System.out.println("This programs will allow you to generate your own word search puzzle");
        System.out.println("Please select and option:");
        System.out.println("Generate a new word search (g)");
        System.out.println("Print out your word search (p)");
        System.out.println("Show the solution to your word search(s)");
        System.out.println("Quit the program (q)");
    }

    // Reads words from a specified text file and returns them as an array of strings.
    // Arguments: filename 
    // Returns: String[] 
    // Exception: FileNotFoundException 

    private static String[] fetchWordsFromFile(String filename) throws FileNotFoundException {

        ArrayList < String > words = new ArrayList < > ();
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine().toLowerCase());
        }
        return words.toArray(new String[0]);
    }

    // Displays the generated word search.
    // Arguments: ws 

    public static void print(GSMWordSearch ws){
      System.out.println(ws);
    }

    // Outputs the solution to the generated word search.
    // Arguments: ws

    public static void displaySolution(GSMWordSearch ws) {

        System.out.println(ws.toSolution());
    }
}