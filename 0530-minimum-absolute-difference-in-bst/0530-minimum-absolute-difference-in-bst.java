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
    int last = Integer.MAX_VALUE;
    int res = Integer.MAX_VALUE;
//     public int totalNode(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         int l = totalNode(root.left);
//         int r = totalNode(root.right);
        
//         return 1+l+r;
//     }
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode root){
        if(root.left != null){
            inOrder(root.left);
        }
        res = Math.min(res,Math.abs(root.val-last));
        last = root.val;
        
        if(root.right != null){
            inOrder(root.right);
        }
    }
}