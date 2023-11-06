class SeatManager {
    private PriorityQueue<Integer> pq;
    
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for (int sn = 1; sn <= n; ++sn) {
            pq.offer(sn);
        }
    }
    
    public int reserve() {
        int sn = pq.poll();
        return sn;
    }
    
    public void unreserve(int sn) {
        pq.offer(sn);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */