class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums) pq.add(i);
        long ans = 0;
        while(k > 0){
            int top = pq.poll();
            ans += top;
            pq.add((top  + 2)/ 3);
            k--;
        }
        return ans;
    }
}