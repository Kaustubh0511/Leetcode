class Solution {
    public int expand(int i,int j,String s){
        int left = i;
        int right = j;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] ans = new int[]{0,0};
        
        for(int i=0;i<n;i++){
            int ol = expand(i,i,s);
            if(ol > ans[1] - ans[0] + 1){
                int dist = ol/2;
                ans[0] = i-dist;
                ans[1] = i+dist;
            }
            int el = expand(i,i+1,s);
            if(el > ans[1] - ans[0]+1){
                int dist = (el/2) - 1;
                ans[0] = i - dist;
                ans[1] = i + dist+1;
            }
        }
        int i = ans[0];
        int j = ans[1];
        
        return s.substring(i,j+1);
    }
}