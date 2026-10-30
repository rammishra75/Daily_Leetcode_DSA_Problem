class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return func(nums, 0, n - 1, 0, 0, 0);
    }
    public boolean func(int[] arr, int i, int j, int plyr1, int plyr2, int chance){
        if(i == j){
            if(chance == 0){
                plyr1 += arr[i];
            }
            else plyr2 += arr[i];
            return plyr1 >= plyr2;    
        }
        if(chance == 0){
            return (func(arr, i + 1, j, plyr1 + arr[i], plyr2, 1) || func(arr, i, j - 1, plyr1 + arr[j], plyr2, 1));
        }
        else{
            return (func(arr, i + 1, j, plyr1, plyr2 + arr[i], 0) && func(arr, i, j - 1, plyr1, plyr2 + arr[j], 0));
        }
    }
}