class Solution {
    public boolean isPossible(int[] arr, int M, int max){
        int currL = 0;
        int d = 1;
        for(int i = 0; i < arr.length; i++){
            if(currL + arr[i] > max){
                d++;
                currL = arr[i];
            } 
            else{
                currL += arr[i];
            }
        }
        return d <=  M;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(isPossible(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}