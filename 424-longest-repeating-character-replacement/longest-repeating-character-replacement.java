class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxfreq = 0;
        int maxlen = 0;
        int[] arr = new int[26];
        while(r < s.length()){
            arr[s.charAt(r) - 'A']++;
            maxfreq = Math.max(maxfreq, arr[s.charAt(r) - 'A']);
            if((r - l + 1 ) - maxfreq > k){
                arr[s.charAt(l) - 'A']--;
                //mafreq = 0;
                l += 1;
            }
            if((r - l + 1) - maxfreq <= k){
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
    }
}