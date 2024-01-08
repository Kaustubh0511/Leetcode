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
    public int rangeSumBST(TreeNode root, int low, int high) {
         Queue<TreeNode> q = new LinkedList<>();
        int sum =0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){ 
                TreeNode curr = q.poll();
                if(curr.val >= low && curr.val <= high){
                    sum += curr.val;
                    //System.out.print(sum +" ");
                }
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }
        return sum;
    }
}