import java.io.*;
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}



class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEndOfWord;
    }
}

public class CompoundedWords {
    private static boolean isCompoundedWord(String word, Trie trie, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (trie.search(prefix)) {
                if (trie.search(suffix) || isCompoundedWord(suffix, trie, memo)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }
        memo.put(word, false);
        return false;
    }

    private static void findCompoundedWords(String filePath) {
        long startTime = System.currentTimeMillis();
        Trie trie = new Trie();
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String word = line.trim();
                words.add(word);
                trie.insert(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> compoundedWords = new ArrayList<>();
        Map<String, Boolean> memo = new HashMap<>();

        // Sort words by length to ensure smaller words are processed first
        words.sort(Comparator.comparingInt(String::length));

        for (String word : words) {
            if (isCompoundedWord(word, trie, memo)) {
                compoundedWords.add(word);
            }
        }

        // Sort compounded words by length in descending order
        compoundedWords.sort((a, b) -> Integer.compare(b.length(), a.length()));

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        if (compoundedWords.size() >= 1) {
            System.out.println("Longest Compound Word: " + compoundedWords.get(0));
        }
        if (compoundedWords.size() >= 2) {
            System.out.println("Second Longest Compound Word: " + compoundedWords.get(1));
        }
        System.out.println("Time taken to process file " + filePath + ": " + timeTaken + " milliseconds");
    }

    public static void main(String[] args) {
        String inputFile1 = "Input_01.txt";
        String inputFile2 = "Input_02.txt";

        System.out.println("Processing " + inputFile1 + ":");
        findCompoundedWords(inputFile1);

        System.out.println("\nProcessing " + inputFile2 + ":");
        findCompoundedWords(inputFile2);
    }
}