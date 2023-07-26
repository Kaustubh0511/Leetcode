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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root = helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
        return root;
    }
    public TreeNode helper(int[] inorder,int li,int hi,int[] postorder,int lp,int hp,HashMap<Integer,Integer> hm){
        if(lp > hp || li> hi) return null;
        TreeNode root = new TreeNode(postorder[hp]);
        
        int ri  = hm.get(postorder[hp]);
        int nl = ri - li;
        
        root.left = helper(inorder,li,ri-1,postorder,lp,lp+ri-li-1,hm);
        root.right = helper(inorder,ri+1,hi,postorder,lp+ri-li,hp-1,hm);
        
        return root;
    }
}