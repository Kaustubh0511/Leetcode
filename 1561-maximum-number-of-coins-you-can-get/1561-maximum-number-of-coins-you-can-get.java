class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        ArrayDeque<Integer> q = new ArrayDeque();
        
        for(int num : piles){
            q.addLast(num);
        }
        
        int res = 0;
        while(!q.isEmpty()){
            q.removeLast();
            res += q.removeLast();
            q.removeFirst();
        }
        
        return res;
    }
}