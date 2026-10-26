class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        
        for (char c : target.toCharArray()) {
            // Step 1: Simulate pressing Key 1 (Appends 'a')
            temp.append('a');
            ans.add(temp.toString());
            
            // Step 2: Simulate pressing Key 2 (Increments the last char until it matches c)
            for (char ch = 'b'; ch <= c; ch++) {
                temp.setCharAt(temp.length() - 1, ch);
                ans.add(temp.toString());
            }
        }
        
        return ans;
    }
}
