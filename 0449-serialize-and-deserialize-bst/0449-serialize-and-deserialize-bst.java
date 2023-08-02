/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res =  new StringBuilder(); 
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.val+" ");
            q.offer(node.left);
            q.offer(node.right);
            
        }
        // System.out.println(res);
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] d = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(d[0]));
        q.offer(root);
        for(int i=1;i<d.length;i++){
            TreeNode parent = q.poll();
            if(!d[i].equals("n")){
                TreeNode left =new TreeNode(Integer.parseInt(d[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!d[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(d[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;