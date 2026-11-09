class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        int i = 0; 
        int n = s1.length();
        int j = 0;
        while(i < n){
            if(s1.charAt(i) != s2.charAt(i)){
                j = i;
                while(j < n){
                    if(s1.charAt(j) != s2.charAt(j)){
                        j++;
                    }
                    else break;
                }
                if(j - i + 1 > 0){
                    List<String> temp = new ArrayList<>();
                    temp.add(s1.substring(i, j));
                    temp.add(s2.substring(i, j));
                    ans.add(temp);
                }
                i = j;
            }
            i++;
        }
        return ans;
    }
}