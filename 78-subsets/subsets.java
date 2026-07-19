class Solution {
    public void generate(int ind, int n, int[] nums, List<Integer> temp, List<List<Integer>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        generate(ind + 1, n, nums, temp, ans);
        temp.remove(temp.size() - 1);
        generate(ind + 1, n, nums, temp, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int l = nums.length;
        int subset = 1 << l;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generate(0, l, nums, temp, ans);
        return ans;
    }
}