class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sp = Arrays.copyOf(people,people.length);
        Arrays.sort(sp);
        
        Arrays.sort(flowers,(a,b) -> Arrays.compare(a,b));
        Map<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i =0;
        for(int p :sp){
            while(i<flowers.length && flowers[i][0] <= p){
                pq.add(flowers[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<p){
                pq.remove();
            }
            
            hm.put(p,pq.size());
        }
        
        int[] res = new int[people.length];
        for(int j=0;j<people.length;j++){
            res[j] = hm.get(people[j]);
        }
        
        return res;
    }
}