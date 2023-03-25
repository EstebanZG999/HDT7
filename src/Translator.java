import java.util.*;
import java.io.*;

public class Translator {
    static Node root = null;

    public static void main(String[] args) {
        /*insert("house", "house", "casa", "loger");
        insert("dog", "dog", "perro", "chien");
        insert("homework", "homework", "tarea", "devoirs");
        insert("woman", "woman", "mujer", "femme");
        insert("town", "town", "pueblo", "ville");
        insert("yes", "yes", "si", "oui");
        insert("casa", "house", "casa", "loger");
        insert("perro", "dog", "perro", "chien");
        insert("tarea", "homework", "tarea", "devoirs");
        insert("mujer", "woman", "mujer", "femme");
        insert("pueblo", "town", "pueblo", "ville");
        insert("si", "yes", "si", "oui");
        insert("loger", "house", "casa", "loger");
        insert("chien", "dog", "perro", "chien");
        insert("devoirs", "homework", "tarea", "devoirs");
        insert("femme", "woman", "mujer", "femme");
        insert("ville", "town", "pueblo", "ville");
        insert("Oui", "yes", "si", "oui");*/

        readTxtFile();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to translate: ");
        String word = scanner.nextLine().toLowerCase();

        System.out.print("Enter the language to translate to (english, spanish, french): ");
        String lang = scanner.nextLine().toLowerCase();

        String[] translations = WordReader.search(root, word);
        if (translations == null) {
            System.out.println("Word not found");
        } else {
            if (lang.equals("english")) {
                System.out.println("English: " + translations[1]);
            } else if (lang.equals("spanish")) {
                System.out.println("Spanish: " + translations[2]);
            } else if (lang.equals("french")) {
                System.out.println("French: " + translations[3]);
            } else {
                System.out.println("Invalid language");
            }
        }
    }


    public static void readTxtFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/HDT7_DATOS.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] words = line.split("\\|");
                if (words.length == 4) {
                    insert(words[0].trim(), words[1].trim(), words[2].trim(), words[3].trim());
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String word, String english, String spanish, String french) {
        root = insertNode(root, word, english, spanish, french);
    }

    private static Node insertNode(Node node, String word, String english, String spanish, String french) {
        if (node == null) {
            node = new Node(word, english, spanish, french);
            return node;
        }

        if (word.compareTo(Node.word) < 0) {
            Node.left = insertNode(Node.left, word, english, spanish, french);
        } else if (word.compareTo(Node.word) > 0) {
            Node.right = insertNode(Node.right, word, english, spanish, french);
        }

        return node;
    }

    public static class WordReader {
        public static String[] search(Node node, String word) {
            if (node == null) {
                return null;
            }

            if (word.compareTo(node.word) == 0) {
                return new String[] {node.word, node.english, node.spanish, node.french};
            } else if (word.compareTo(node.word) < 0) {
                return search(node.left, word);
            } else {
                return search(node.right, word);
            }
        }
    }
}

        /*TreeNode result = search(root, word);
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

*/