package y2026.May;

import java.util.Arrays;

public class lc3093 {
    class Trie {
        private TrieNode root;
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int index = -1;
        }
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String[] wordsContainer, int wordIndex) {
            TrieNode cur = root;
            if (better(wordsContainer, wordIndex, cur.index)) {
                cur.index = wordIndex;
            }

            String word = wordsContainer[wordIndex];
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';

                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }

                cur = cur.children[index];
                if (better(wordsContainer, wordIndex, cur.index)) {
                    cur.index = wordIndex;
                }
            }
        }

        public int query(String word) {
            TrieNode cur = root;
            int ans = cur.index;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    break;
                }
                cur = cur.children[index];
                ans = cur.index;
            }
            return ans;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie root = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            root.insert(wordsContainer, i);
        }
        int [] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = root.query(wordsQuery[i]);
        }
        return ans;
    }

    private boolean better(String[] wordsContainer, int a, int b) {
        if (b == -1) {
            return true;
        }
        if (wordsContainer[a].length() != wordsContainer[b].length()) {
            return wordsContainer[a].length() < wordsContainer[b].length();
        }
        return a < b;
    }

    public static void main(String[] args) {

        int[] x = new lc3093().stringIndices(
                new String[]{"abcd", "bcd", "xbcd"},
                new String[]{"cd", "bcd", "xyz"});
        Arrays.stream(x).forEach(t->System.out.println(t));;
        System.out.println(x);
        int[] x1 = new lc3093().stringIndices(
                new String[]{"abcdefgh", "poiuygh", "ghghgh"},
                new String[]{"gh", "acbfgh", "acbfegh"});
        Arrays.stream(x1).forEach(t->System.out.println(t));;


    }
}
