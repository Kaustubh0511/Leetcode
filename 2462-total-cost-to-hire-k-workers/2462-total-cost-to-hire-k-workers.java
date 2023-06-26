class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int i =0;
        int j = n-1;
        long sum =0;
        while(k>0){
            while(pq1.size() < candidates && i<= j) {
                pq1.add(costs[i]);
                i++;
            }
            while(pq2.size() < candidates && j >= i) {
                pq2.add(costs[j]);
                j--;
            }
            //System.out.println(pq2);
            int a = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int b = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;
            if(a<=b){
                sum += a;
                pq1.poll();
            }
            else{
                sum += b;
                pq2.poll();
            }
            k--;
        }
        return sum;
    }
}