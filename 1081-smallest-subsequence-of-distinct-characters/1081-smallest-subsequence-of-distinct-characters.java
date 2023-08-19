class Solution {
    public String smallestSubsequence(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[26];
        
        int[] a = new int[26];
        for(int i= 0;i<s.length();i++){
            a[s.charAt(i) - 'a']  = i;
        }
        
        for(int i=0;i<s.length();i++){
            int cur = s.charAt(i) - 'a';
            if(vis[cur]) continue;
            while(!st.isEmpty() && st.peek() > cur && i<a[st.peek()]){
                vis[st.pop()] = false;
            }
            
            st.push(cur);
            vis[cur] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        
        return sb.reverse().toString();
    }
}