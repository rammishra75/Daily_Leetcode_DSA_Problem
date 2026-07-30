class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int cnt = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            HashSet<Integer> set2 = new HashSet<>();
            for(int j = i; j < n; j++){
                set2.add(nums[j]);
                if(set2.size() == set.size()){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}