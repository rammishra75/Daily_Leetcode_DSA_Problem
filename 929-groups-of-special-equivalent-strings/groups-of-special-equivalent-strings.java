class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> seen = new HashSet<>();
        for(String s: words){
            int[] cnt = new int[52];
            for(int i = 0; i < s.length(); i++){
                cnt[s.charAt(i) - 'a' + 26 * (i % 2)]++;
            }
            seen.add(Arrays.toString(cnt));
        }
        return seen.size();
    }
}