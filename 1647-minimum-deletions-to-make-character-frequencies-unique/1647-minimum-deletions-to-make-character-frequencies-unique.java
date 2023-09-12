class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        Set<Integer> uniq = new HashSet<>();
        int count = 0;
        
        for(Map.Entry<Character,Integer> en : hm.entrySet()){
            int f = en.getValue();
            while(f > 0 && uniq.contains(f)){
                f--;
                count++;
            }
            uniq.add(f);
        }
        
        return count;
    }
}