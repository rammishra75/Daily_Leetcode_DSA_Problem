class Solution {
    public void func(int ind, int[] arr, int target, int n, List<List<Integer>> ans, List<Integer> temp){
        if(ind == n){
            if(target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[ind] <= target){
            temp.add(arr[ind]);
            func(ind, arr, target - arr[ind], n, ans, temp);
            temp.remove(temp.size() - 1);
        }
        func(ind + 1, arr, target, n, ans, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        func(0, candidates, target, n, ans, new ArrayList<>());
        return ans;
    }
}