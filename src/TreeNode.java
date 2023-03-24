public class TreeNode {
    String word;
    String english;
    String spanish;
    String french;
    TreeNode left;
    TreeNode right;

    public TreeNode(String word, String english, String spanish, String french) {
        this.word = word;
        this.english = english;
        this.spanish = spanish;
        this.french = french;
        this.left = null;
        this.right = null;
    }
}
