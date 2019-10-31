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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[1];
        int[] count = {k};
        
        helper(root, count, result);
        return result[0];
    }
    
    /*
        为什么helper里我没有把k以int k的形式传下去，这就涉及到Java Pass by Value的问题了，
        如果我在最初的helper里先把int k传下去了（这里假设k == 3），那么我这个helper里面的helper(root.left, count, result)用的就是3，
        然后这里面执行count--后，helper(root.right, count, result)用到的实际是2。
        但是，我需要的这个count用到的是我最新的count值，也就是说我在进入helper(root.left, count, result)之后这里面也会对count进行update，
        我希望这个最新的值被传到helper(root.right, count, result)里去，因此我们这里把k放进一个数组里，相当于我们pass by value传的是一个reference，
        每次都对那个地址指向的内容进行更改，这样就一直用的是更新过的内容了。
    */
    public void helper(TreeNode root, int[] count, int[] result) {
        // base case
        if(root == null){
            return;
        }
        
        helper(root.left, count, result);
        
        count[0]--;
        if(count[0] == 0){
            result[0] = root.val;
            return;
        }
        
        helper(root.right, count, result);
    }
}