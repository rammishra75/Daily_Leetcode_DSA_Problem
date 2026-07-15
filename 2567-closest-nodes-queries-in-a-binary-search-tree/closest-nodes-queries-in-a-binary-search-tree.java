/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findmin(int num, List<Integer> arr){
        int ans = -1;
        int low = 0;
        int high = arr.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) >= num){
                ans = arr.get(mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        //if(ans == Integer.MIN_VALUE) return -1;
        return ans;
    }
    public int findmax(int num, List<Integer> arr){
        int ans = -1;
        int low = 0;
        int high = arr.size() - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) <= num){
                ans = arr.get(mid);
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public void traverse(TreeNode root, List<Integer> arr){
        if(root == null) return;
        traverse(root.left, arr);
        arr.add(root.val);
        traverse(root.right, arr);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        traverse(root, arr);
        for(int i : queries){
            int max = findmin(i, arr);
            int min = findmax(i, arr);
            List<Integer> temp = new ArrayList<>();
            temp.add(min);
            temp.add(max);
            ans.add(temp);
        }
        return ans;
    }
}