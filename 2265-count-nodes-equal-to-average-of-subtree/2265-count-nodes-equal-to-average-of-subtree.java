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
class Pair{
    int getKey;
    int getValue;
    
    public Pair(int a,int b){
        this.getKey = a;
        this.getValue = b;
    }
}
class Solution {
    
    int count;
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return count;
    }
    
    public Pair solve(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }
        
        Pair l1 = solve(root.left);
        Pair r1 = solve(root.right);
        
        int n = l1.getValue + r1.getValue+1;
        int sum = root.val + l1.getKey + r1.getKey;
        int avg = sum/n;
        if(avg == root.val)
            count++;
        return new Pair(sum,n);
    }
}