class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] p = new int[n][2];
        for(int i =0;i<n;i++){
            p[i] = new int[]{nums2[i], nums1[i]};
        }
        Arrays.sort(p, (a,b)-> b[0]-a[0]);
        PriorityQueue <Integer> pq = new PriorityQueue<>(k,(a,b) -> a-b);
        long cur =0, max = 0;
        for(int[] pair:p){
            pq.add(pair[1]);
            cur += pair[1];
            if(pq.size()>k){
                cur -= pq.poll();
            }
            if(pq.size()==k){
                max = Math.max(max,cur*pair[0]);
            }
        }
        return max;
    }
}