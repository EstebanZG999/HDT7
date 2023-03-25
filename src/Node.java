public class Node {
    static String word;
    String english;
    String spanish;
    String french;
    static Node left;
    static Node right;

    public Node(String word, String english, String spanish, String french) {
        this.word = word;
        this.english = english;
        this.spanish = spanish;
        this.french = french;
        this.left = null;
        this.right = null;
    }
}
