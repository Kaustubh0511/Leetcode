class Solution {
    public int getWinner(int[] arr, int k) {
        int maxi = arr[0];
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
            q.offer(arr[i]);
        }
        
        int curr = arr[0];
        int winstreak = 0;
        
        while (!q.isEmpty()) {
            int opponent = q.poll();
            
            if (curr > opponent) {
                q.offer(opponent);
                winstreak++;
            } else {
                q.offer(curr);
                curr = opponent;
                winstreak = 1;
            }
            
            if (winstreak == k || curr == maxi) {
                return curr;
            }
        }
        
        return -1;
    }
}