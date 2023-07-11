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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> l  =new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer,TreeNode> map = new HashMap<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                if(top.left != null){
                    map.put(top.left.val,top);
                    q.offer(top.left);
                }
                if(top.right != null){
                    map.put(top.right.val,top);
                    q.offer(top.right);
                }
            }
        }
        Map<Integer,Integer> hm = new HashMap<>();
        q.offer(target);
        while(k>0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                hm.put(top.val,1);
                if(top.left != null && !hm.containsKey(top.left.val)){
                    q.offer(top.left);
                }
                if(top.right != null && !hm.containsKey(top.right.val)){
                    q.offer(top.right);
                }
                if(map.containsKey(top.val) && !hm.containsKey(map.get(top.val).val)){
                    q.offer(map.get(top.val));
                }
            }
            k--;
        }
        
        while(!q.isEmpty()){
            l.add(q.poll().val);
        }
        return l;
    }
}