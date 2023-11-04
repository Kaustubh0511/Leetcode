class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ln = left.length;
        int rn = right.length;
        int res = 0;
        
        for(int num : left){
            res = Math.max(res,num);
        }
        
        for(int num : right){
            res = Math.max(res,n-num);
        }
        
        return res;
    }
}