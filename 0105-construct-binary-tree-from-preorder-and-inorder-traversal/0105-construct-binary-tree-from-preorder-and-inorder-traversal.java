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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root = helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hm);
        return root;
    }
    public TreeNode helper(int[] preorder,int lp,int hp,int[] inorder,int li,int hi,HashMap<Integer,Integer> hm){
        if(lp > hp || li> hi) return null;
        TreeNode root = new TreeNode(preorder[lp]);
        
        int ri  = hm.get(root.val);
        int nl = ri - li;
        
        root.left = helper(preorder,lp+1,lp+nl,inorder,li,ri+1,hm);
        root.right = helper(preorder,lp+nl+1,hp,inorder,ri+1,hi,hm);
        
        return root;
    }
}