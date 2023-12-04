class Solution {
    public String largestGoodInteger(String num) {
        char max = '\0';
        int n = num.length();
        for(int i = 0;i<=n-3;i++){
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                max = (char) Math.max(max, num.charAt(i));
            }
        }
        
        return max == '\0' ? "" : new String(new char[]{max,max,max});
    }
}