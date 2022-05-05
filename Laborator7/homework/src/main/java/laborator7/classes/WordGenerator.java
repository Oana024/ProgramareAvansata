package laborator7.classes;

import java.util.ArrayList;
import java.util.List;

public class WordGenerator {

    static final int SIZE = 26;

    static class TrieNode {
        TrieNode[] Child = new TrieNode[SIZE];

        boolean leaf;

        public TrieNode() {
            leaf = false;
            for (int i = 0; i < SIZE; i++)
                Child[i] = null;
        }
    }

    static void insert(TrieNode root, String Key) {
        int n = Key.length();
        TrieNode pChild = root;

        for (int i = 0; i < n; i++) {
            int index = Key.charAt(i) - 'a';

            if (pChild.Child[index] == null)
                pChild.Child[index] = new TrieNode();

            pChild = pChild.Child[index];
        }

        pChild.leaf = true;
    }

    static void searchWord(TrieNode root, boolean Hash[], String str, List<String> result) {
        if (root.leaf) {
            if (str.length() <= 7)
                result.add(str);
        }

        for (int K = 0; K < SIZE; K++) {
            if (Hash[K] && root.Child[K] != null) {
                char c = (char) (K + 'a');

                searchWord(root.Child[K], Hash, str + c, result);
            }
        }
    }

    static void PrintAllWords(char Arr[], TrieNode root, int n, List<String> result) {
        boolean[] Hash = new boolean[SIZE];

        for (int i = 0; i < n; i++)
            Hash[Arr[i] - 'a'] = true;

        TrieNode pChild = root;

        String str = "";

        for (int i = 0; i < SIZE; i++) {
            if (Hash[i] && pChild.Child[i] != null) {
                str = str + (char) (i + 'a');
                searchWord(pChild.Child[i], Hash, str, result);
                str = "";
            }
        }
    }

    public List<String> search(Dictionary dictionary, String letters) {
        Dictionary Dict = new MockDictionary();

        TrieNode root = new TrieNode();

        int n = Dict.getSize();
        for (int i = 0; i < n; i++)
            insert(root, Dict.getWord(i));

        char arr[] = letters.toCharArray();
        int N = arr.length;

        List<String> result = new ArrayList<>();
        List<String> possibleWords = new ArrayList<>();

        PrintAllWords(arr, root, N, result);

        List<Character> letterList = new ArrayList<>();

        for (char s : arr) {
            letterList.add(s);
        }

        List<Character> copy = new ArrayList<>();
        Character usedLetter;

        int ok;

        for (String s : result) {
            ok = 1;
            copy.addAll(letterList);
            for (char letter : s.toCharArray()) {
                usedLetter = null;
                for (char l : copy)
                    if (l == letter) {
                        usedLetter = l;
                    }

                if (usedLetter != null)
                    copy.remove(usedLetter);
                else
                    ok = 0;
            }
            copy.clear();
            if (ok == 1) {
                possibleWords.add(s);
            }
        }

        return possibleWords;
    }
}
