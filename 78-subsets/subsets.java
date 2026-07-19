class Solution {
        public List<List<Integer>> subsets(int[] nums) {
        int l = nums.length;
        int subset = 1 << l;
        List<List<Integer>> ans = new ArrayList<>();
        for(int n = 0; n < subset; n++){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < l; i++){
                if((n & (1 << i)) != 0){
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        } 
        return ans;
    }
}