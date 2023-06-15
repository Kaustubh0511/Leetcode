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
//     public int hieght(TreeNode root){
//         if(root == null){
//             return 0;
//         }
//         int lh = hieght(root.left);
//         int rh = hieght(root.right);
        
//         if(lh>rh){
//             return (lh +1);
//         }
//         else{
//             return (rh +1);
//         }
//     }
    public int maxLevelSum(TreeNode root) {
        int maxSum  = Integer.MIN_VALUE;
        //int max = 0;
        int level = 0;
        int maxLevel = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            level++;
            if(sum >maxSum){
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
    // public int levelOrder(TreeNode root, int level){
    //     int sum = 0;
    //     if(root == null){
    //         return 0;
    //     }
    //     if(level == 1){
    //         sum = root.val;
    //     }
    //     else if(level > 1){
    //         if(root.left == null){
    //             sum = root.right.val;
    //         }
    //         else if(root.right == null){
    //             sum = root.left.val;
    //         }
    //         else{
    //             sum = root.left.val + root.right.val;   
    //         }
    //         levelOrder(root.left,level-1);
    //         levelOrder(root.right,level-1);
    //     }
    //     return sum;
    // }
}