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
    public List<TreeNode> solve(int s,int e,Map<Pair<Integer,Integer>,List<TreeNode>> memo){
        List<TreeNode> res = new ArrayList<>();
        if(s > e){
            res.add(null);
            return res;
        }
        if(memo.containsKey(new Pair<>(s,e))){
            return memo.get(new Pair<>(s,e));
        }
        for(int i =s;i<=e;i++){
            List<TreeNode> left = solve(s,i-1,memo);
            List<TreeNode> right = solve(i+1,e,memo);
            
            for(TreeNode tl : left){
                for(TreeNode tr : right){
                    TreeNode root = new TreeNode(i,tl,tr);
                    res.add(root);
                }
            }
        }
        memo.put(new Pair<>(s,e),res);
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        Map<Pair<Integer,Integer>,List<TreeNode>> memo = new HashMap<>();
        return solve(1,n,memo);
    }
}