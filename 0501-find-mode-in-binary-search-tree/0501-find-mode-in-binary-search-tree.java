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
    public int[] findMode(TreeNode root) {
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            TreeNode cur = q.poll();
            hm.put(cur.val,hm.getOrDefault(cur.val,0)+1);

            if(cur.left != null){
                q.offer(cur.left);
            }

            if(cur.right != null){
                q.offer(cur.right);
            }
        }
        
        int max = 0;
        for(int k : hm.keySet()){
            max = Math.max(max,hm.get(k));
        }
        
        List<Integer> li = new ArrayList<>();
        for(int k : hm.keySet()){
            if(hm.get(k) == max){
                li.add(k);
            }
        }
        
        int[] res = new int[li.size()];
        for(int i =0;i<li.size();i++){
            res[i] = li.get(i);
        }
        
        return res;
    }
}