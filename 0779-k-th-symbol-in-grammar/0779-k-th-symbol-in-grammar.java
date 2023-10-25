class Solution {
    public int kthGrammar(int n, int k) {
        return dfs(n,k,0);
    }
    public int dfs(int n, int k, int rv){
        if(n == 1){
            return rv;
        }
        
        int tn = (int)Math.pow(2,n-1);
        
        if(k > (tn/2)){
            int nrv = (rv == 0) ? 1 : 0;
            return dfs(n-1,k-(tn/2),nrv);
        }
        
        else{
            int nrv = (rv == 0) ? 0 : 1;
            return dfs(n-1,k,nrv);
        }
    }
}