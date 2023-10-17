class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n,leftChild,rightChild);
        
        if(root == -1){
            return false;
        }
        
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        vis.add(root);
        q.add(root);
        
        while(!q.isEmpty()){
            int node = q.poll();
            int[] child = {leftChild[node],rightChild[node]};
            
            for(int c : child){
                if(c != -1){
                    if(vis.contains(c)){
                        return false;
                    }
                    q.add(c);
                    vis.add(c);
                }
            }
        }
        return vis.size() == n;
    }
    
    public int findRoot(int n,int[] leftChild,int[] rightChild){
        Set<Integer> c = new HashSet<>();
        for(int node : leftChild){
            c.add(node);        
        }
        
        for(int node : rightChild){
            c.add(node);
        }
        
        for(int i =0;i<n;i++){
            if(!c.contains(i)){
                return i;
            }
        }
        return -1;
    }
}