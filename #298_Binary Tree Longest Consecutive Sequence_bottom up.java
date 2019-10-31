/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        // corner case
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        
        helper(root, max);
        return max[0];
    }
    
    // helper function : DFS - bottom up
    public int helper(TreeNode root, int[] max) {
        // base case
        if (root == null) {
            return 0;
        }
        
        //what I want from my children
        int left = helper(root.left, max);
        int right = helper(root.right, max);
            
        int leftConseq = left == 0 ? 1: (root.left.val - root.val == 1) ? left + 1: 1;
        int rightConseq = right == 0 ? 1: (root.right.val - root.val == 1) ? right + 1: 1;
        
        int curMax = Math.max(leftConseq, rightConseq);
        max[0] = Math.max(max[0], curMax);
        
        // what I need to return to my parent
        return curMax;

    }
}