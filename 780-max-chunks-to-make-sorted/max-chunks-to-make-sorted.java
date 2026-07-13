class Solution {
    public int maxChunksToSorted(int[] arr) {
        int sum=0;
        int perm=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            perm=perm+i;
            if(sum==perm){
                count++;
            }
        }
        return count;
    }
}