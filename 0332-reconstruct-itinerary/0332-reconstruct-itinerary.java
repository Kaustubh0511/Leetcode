class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> hm = new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            if(!hm.containsKey(tickets.get(i).get(0))){
                PriorityQueue<String> pq = new PriorityQueue<>();
                hm.put(tickets.get(i).get(0),pq);
            }
            hm.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }
        LinkedList<String> l = new LinkedList<>();
        dfs("JFK",hm,l);
        return l;
    }
    private void dfs(String s,HashMap<String,PriorityQueue<String>> hm,LinkedList<String> l){
        PriorityQueue<String> pq = hm.get(s);

        while(pq!=null && !pq.isEmpty()){

            dfs(pq.poll(), hm, l);

        }

        l.addFirst(s);
    }
}