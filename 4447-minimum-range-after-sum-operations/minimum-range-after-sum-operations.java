class Solution {
    public int minRange(int a, int b, int c) {
        int[] arr = new int[3];
        arr[0] = a; 
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        int ans = Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
        arr[0] = arr[1] + arr[2];
        ans = Math.min(ans, Math.max(arr[1], arr[0] - arr[2]));
        return ans;

    }
}