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
    public TreeNode buildTree(int left, int right, List<Integer> arr){
        if(left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTree(left, mid - 1, arr);
        root.right = buildTree(mid + 1, right, arr);
        return root;
    }
    public void traverse(TreeNode root, List<Integer> arr){
        if(root == null) return;
        traverse(root.left, arr);
        arr.add(root.val);
        traverse(root.right, arr);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>(); 
        traverse(root, arr);
        return buildTree(0, arr.size() - 1, arr);
    }
}