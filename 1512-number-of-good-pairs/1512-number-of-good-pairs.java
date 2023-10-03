class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> en : hm.entrySet()){
            int n = en.getValue();
            count += ((n*(n-1))/2);
        }
        return count;   
    }
}