class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int l = 0;
        int maxf = 0;
        int res = 0;
        int n = answerKey.length();
        int[] cnt = new int[26];
        for(int r = 0; r < n; r++){
            cnt[answerKey.charAt(r) - 'A']++;
            maxf = Math.max(maxf,  cnt[answerKey.charAt(r) - 'A']);
            while(r - l + 1 > maxf + k){
                cnt[answerKey.charAt(l++) - 'A']--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}