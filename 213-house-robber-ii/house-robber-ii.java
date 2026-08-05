class Solution {
    public int func(ArrayList<Integer>arr){
        int prev = arr.get(0);
        int prev2 = 0;
        int  n = arr.size();
        for(int i = 1; i < n; i++){
            int pick = arr.get(i);
            if(i > 1) pick += prev2;
            int notpick = prev;
            int curri = Math.max(pick, notpick);
            prev2 = prev;
            prev = curri; 
        }
        return prev;
    }
    public int rob(int[] nums) {
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        int n = nums.length;
        if(n == 1) return nums[0];
        for(int i = 0; i < n; i++){
            if(i > 0) temp1.add(nums[i]);
            if(i < n - 1) temp2.add(nums[i]);
        }
        int ans1 = func(temp1);
        int ans2 = func(temp2);
        return Math.max(ans1, ans2);
    }
}