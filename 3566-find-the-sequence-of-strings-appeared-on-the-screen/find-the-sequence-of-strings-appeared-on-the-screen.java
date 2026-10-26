class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        int ind = 0;
        for(char c: target.toCharArray()){
            char ch = 'a';
            while(ch < c){
                if(ind == 0) ans.add(Character.toString(ch));
                else {
                    temp.append(ch);
                    ans.add(temp.toString());
                    temp.deleteCharAt(temp.length() - 1);
                }
                ch++;
            }
            temp.append(ch);
            ans.add(temp.toString());
            ind++;
        }
        return ans;
    }
}