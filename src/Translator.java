import java.util.Scanner;

class TreeNode {
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

public class Translator {
    static TreeNode root = null;

    public static void main(String[] args) {
        insert("house", "house", "casa", "loger");
        insert("dog", "dog", "perro", "chien");
        insert("homework", "homework", "tarea", "devoirs");
        insert("woman", "woman", "mujer", "femme");
        insert("town", "town", "pueblo", "ville");
        insert("yes", "yes", "si", "Oui");
        insert("casa", "house", "casa", "loger");
        insert("perro", "dog", "perro", "chien");
        insert("tarea", "homework", "tarea", "devoirs");
        insert("mujer", "woman", "mujer", "femme");
        insert("pueblo", "town", "pueblo", "ville");
        insert("si", "yes", "si", "Oui");
        insert("loger", "house", "casa", "loger");
        insert("chien", "dog", "perro", "chien");
        insert("devoirs", "homework", "tarea", "devoirs");
        insert("femme", "woman", "mujer", "femme");
        insert("ville", "town", "pueblo", "ville");
        insert("Oui", "yes", "si", "Oui");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to translate: ");
        String word = scanner.nextLine();

        System.out.print("Enter the language to translate to (english, spanish, french): ");
        String lang = scanner.nextLine();

        TreeNode result = search(root, word);
        if (result == null) {
            System.out.println("Word not found");
        } else {
            if (lang.equals("english")) {
                System.out.println("English: " + result.english);
            } else if (lang.equals("spanish")) {
                System.out.println("Spanish: " + result.spanish);
            } else if (lang.equals("french")) {
                System.out.println("French: " + result.french);
            } else {
                System.out.println("Invalid language");
            }
        }
    }

    public static void insert(String word, String english, String spanish, String french) {
        root = insertNode(root, word, english, spanish, french);
    }

    private static TreeNode insertNode(TreeNode node, String word, String english, String spanish, String french) {
        if (node == null) {
            node = new TreeNode(word, english, spanish, french);
            return node;
        }

        if (word.compareTo(node.word) < 0) {
            node.left = insertNode(node.left, word, english, spanish, french);
        } else if (word.compareTo(node.word) > 0) {
            node.right = insertNode(node.right, word, english, spanish, french);
        }

        return node;
    }

    public static TreeNode search(TreeNode node, String word) {
        if (node == null || node.word.equals(word)) {
            return node;
        }

        if (word.compareTo(node.word) < 0) {
            return search(node.left, word);
        } else {
            return search(node.right, word);
        }
    }
}

