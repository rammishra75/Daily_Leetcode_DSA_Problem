class Solution {
    List<String> happyString = new ArrayList<>();

    public String getHappyString(int n, int k) {
        String currstr = "";
        generate(n, currstr);
        if(happyString.size() < k) return "";
        return happyString.get(k - 1);
    }

    public void generate(int n, String curr){
        if(curr.length() == n){
            happyString.add(curr);
            return;
        }
        for(char x = 'a'; x <= 'c'; x++){
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == x) continue;
            generate(n, curr + x);
        }
    } 
}