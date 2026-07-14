class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String str = "123456789";
        String strt = Integer.toString(low);
        String end = Integer.toString(high);
        for(int len = strt.length(); len <= end.length(); len++){
            for(int start = 0; start <= 9 - len; start++){
            int num = Integer.parseInt(str.substring(start, start + len));
            if(num >= low && num <= high){
                ans.add(num);
            }
            }
        }
        return ans;
    }
}