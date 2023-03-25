public class Node {
    String word;
    String english;
    String spanish;
    String french;
    Node left;
    Node right;

    public Node(String word, String english, String spanish, String french) {
        this.word = word;
        this.english = english;
        this.spanish = spanish;
        this.french = french;
        this.left = null;
        this.right = null;
    }
}

