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
        if(root == null){
            return 0;
        }
        int[] max = {1};
        helper(root, max, 1);
        return max[0];
    }
    
    // DFS : top down
    private void helper(TreeNode root, int[] max, int counter){

        if(root.left != null){
            if(root.left.val - root.val == 1){
                helper(root.left, max, counter + 1);
                max[0] = Math.max(max[0], counter + 1);
            }else{
                helper(root.left, max, 1);
            }
        }
        
        if(root.right != null){
            if(root.right.val - root.val == 1){
                helper(root.right, max, counter + 1);
                max[0] = Math.max(max[0], counter + 1);

            }else{
                helper(root.right, max, 1);
            }
        }
    }
}