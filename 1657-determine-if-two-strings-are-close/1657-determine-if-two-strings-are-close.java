class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        //System.out.println(n1);
        //System.out.println(n2);
        
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        
        for(char c : word1.toCharArray()){
            hm1.put(c,hm1.getOrDefault(c,0)+1);
        }
        for(char c : word2.toCharArray()){
            hm2.put(c,hm2.getOrDefault(c,0)+1);
        }
        
        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();
        
        for(Map.Entry<Character,Integer> en1 : hm1.entrySet()){
            hs1.add(en1.getKey());
        }
        
        for(Map.Entry<Character,Integer> en2 : hm2.entrySet()){
            hs2.add(en2.getKey());
        }
        
        if(!hs1.equals(hs2)){
            return false;   
        }
        for(Map.Entry<Character,Integer> en1 : hm1.entrySet()){
            pq1.add(en1.getValue());
        }
        
        for(Map.Entry<Character,Integer> en2 : hm2.entrySet()){
            pq2.add(en2.getValue());
        }
        while(!pq1.isEmpty()){
            //System.out.println(pq1.peek());
            //System.out.println(pq2.peek());
            int a = pq1.poll();
            int b = pq2.poll();
            if(a != b){
                return false;
            }
        }
        
        return true;
    }
}