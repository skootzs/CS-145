// Gabriella Samantha Maria
// 05/31/2023
// CS 145
// Lab 6 - 20 Questions
// Class - QuestionNode

public class QuestionNode {
    public String data; // data stored at this node
    public QuestionNode left;
    public QuestionNode right;
    public QuestionNode(String data) {
        this(data, null, null);
        // TODO Auto-generated constructor stub
    }
    public QuestionNode(String data, QuestionNode left, QuestionNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}