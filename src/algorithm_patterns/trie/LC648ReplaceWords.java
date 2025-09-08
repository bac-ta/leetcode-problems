package algorithm_patterns.trie;

import java.util.List;

public class LC648ReplaceWords {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String w) {
        TrieNode node = root;
        for (char c : w.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.word = w;
    }

    public String search(String w) {
        TrieNode node = root;
        for (char c : w.toCharArray()) {
            if (node.word == null) return node.word;

            int idx = c - 'a';
            if (node.children[idx] == null) return w;
            node = node.children[idx];
        }
        return node.word != null ? node.word : w;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary.forEach(this::insert);

        var sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            sb.append(search(word)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
