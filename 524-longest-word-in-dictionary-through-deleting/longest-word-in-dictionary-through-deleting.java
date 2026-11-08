public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // 1. Sort dictionary: Longest words first. If lengths are equal, alphabetical order first.
        Collections.sort(dictionary, (a, b) -> {
            if (a.length() != b.length()) {
                return b.length() - a.length(); // Descending by length
            }
            return a.compareTo(b); // Ascending alphabetically
        });

        // 2. Check each word in order. The first one that fits is our winner.
        for (String word : dictionary) {
            if (isSubsequence(s, word)) {
                return word;
            }
        }

        return "";
    }

    // Highly optimized two-pointer check using primitives
    private boolean isSubsequence(String s, String word) {
        int i = 0; // Pointer for s
        int j = 0; // Pointer for word
        
        int sLen = s.length();
        int wLen = word.length();

        // Fast failure: if word is longer than s, it can't be a subsequence
        if (wLen > sLen) return false;

        while (i < sLen && j < wLen) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        
        // If j reached the end of the word, it's a valid subsequence
        return j == wLen;
    }
}
