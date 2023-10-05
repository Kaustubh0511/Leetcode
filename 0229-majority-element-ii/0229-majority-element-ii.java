class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = (n/3);
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        // System.out.println(hm);
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> en : hm.entrySet()){
            if(en.getValue() > a){
                res.add(en.getKey());
            }
        }
        return res;
    }
}