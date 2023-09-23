class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(String a,String b) -> a.length() - b.length());
        Map<String,Integer> memo = new HashMap<>();
        int max = 1;
        for(String w : words){
            int cur = 1;
            StringBuilder sb = new StringBuilder(w);
            
            for(int i = 0;i<w.length();i++){
                sb.deleteCharAt(i);
                String prevWord = sb.toString();
                cur = Math.max(cur, memo.getOrDefault(prevWord, 0) + 1);
                sb.insert(i, w.charAt(i));
            }
            memo.put(w, cur);
            
            max = Math.max(max,cur);
        }
        return max;
    }
}