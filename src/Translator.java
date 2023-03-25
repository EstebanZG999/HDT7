import java.util.*;
import java.io.*;

public class Translator {
    static Node root = null;

    public static void main(String[] args) {

        readTxtFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to translate: ");
        String word = scanner.nextLine().toLowerCase();

        System.out.println("Enter the language to translate to (english, spanish, french): ");
        String lang = scanner.nextLine().toLowerCase();

        String[] translations = WordReader.search(root, word, lang);
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
                String[] words = line.split(",");
                if (words.length >= 4) {
                    insert(words[0].trim(), words[1].trim(), words[2].trim(), words[3].trim());
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
            order(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void order(Node node) {
        if (node == null) {
            return;
        }
        order(node.left);
        System.out.print("\n(" + node.english + ", " + node.spanish + ", " + node.french + ") ");
        System.out.print("\n(" + node.spanish + ", " + node.english + ", " + node.french + ") ");
        System.out.print("\n(" + node.french + ", " + node.english + ", " + node.spanish + ") \n");
        order(node.right);
    }


    public static void insert(String word, String english, String spanish, String french) {
        root = insertNode(root, word, english, spanish, french);
        System.out.println("Palabras para traducir: " + word);
    }

    private static Node insertNode(Node node, String word, String english, String spanish, String french) {
        if (node == null) {
            node = new Node(word, english, spanish, french);
            return node;
        }

        int cmp = word.compareTo(node.word);
        if (cmp < 0) {
            node.left = insertNode(node.left, word, english, spanish, french);
        } else if (cmp > 0) {
            node.right = insertNode(node.right, word, english, spanish, french);
        } else {
            // word already exists, update translations
            node.english = english;
            node.spanish = spanish;
            node.french = french;
        }

        return node;
    }

    public static class WordReader {
        public static String[] search(Node node, String word, String lang) {
            if (node == null) {
                return null;
            }

            int cmp = word.compareTo(node.word);
            if (cmp == 0) {
                if (lang.equals("english")) {
                    return new String[]{node.word, node.english, node.spanish, node.french};
                } else if (lang.equals("spanish")) {
                    return new String[]{node.word, node.english, node.spanish, node.french};
                } else if (lang.equals("french")) {
                    return new String[]{node.word, node.english, node.spanish, node.french};
                }
            } else if (cmp < 0) {
                return search(node.left, word, lang);
            } else {
                return search(node.right, word, lang);
            }

            return null;
        }
    }
}
