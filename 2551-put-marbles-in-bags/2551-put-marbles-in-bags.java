class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        PriorityQueue<Long> small = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> large = new PriorityQueue<>();
        
        long sum1=0;
        long sum2=0;
        
        for(int i=0;i<n-1;i++){
            long pair = weights[i] + weights[i+1];
            small.offer(pair);
            large.offer(pair);
            
            sum1 += pair;
            sum2 += pair;
            
            if(small.size() > k-1){
                sum1 -= small.poll();
            }
            if(large.size() > k-1){
                sum2 -= large.poll();
            }
        }
        
        return sum2 - sum1;
    }
}