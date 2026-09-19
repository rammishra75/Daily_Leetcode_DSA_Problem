class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxwater = 0;
        while(i < j){
            int l = Math.min(height[i],height[j]);
            int b = j - i;
            int curw = l * b;
            if(maxwater < curw){
                maxwater = curw;
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxwater;
    }
}