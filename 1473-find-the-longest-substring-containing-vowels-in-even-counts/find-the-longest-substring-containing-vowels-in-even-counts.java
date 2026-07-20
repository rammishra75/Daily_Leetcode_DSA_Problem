class Solution {
    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] occur = new int[32];
        Arrays.fill(occur, -1);
        int[] c_map = new int[26];
        int longestSubstring = 0;
        c_map['a' - 'a'] = 1;
        c_map['e' - 'a'] = 2;
        c_map['i' - 'a'] = 4;
        c_map['o' - 'a'] = 8;
        c_map['u' - 'a'] = 16;
        for(int i = 0; i < s.length(); i++){
            prefixXOR ^= c_map[s.charAt(i) - 'a'];
            if(occur[prefixXOR] == -1 && prefixXOR != 0) occur[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - occur[prefixXOR]);
        }
        return longestSubstring;
    }
}