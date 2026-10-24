class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for(String s: queries){
            ans.add(helper(s, pattern));
        }
        return ans;
    }
    public boolean helper(String s, String pattern){
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(j < pattern.length() && c == pattern.charAt(j)){
                j++;
            }
            else if(Character.isUpperCase(c)){
                return false;
            }
        }
        return j == pattern.length();
    }
}