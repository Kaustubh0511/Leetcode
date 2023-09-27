public class Solution {
    public String decodeAtIndex(String s, int k) {
        long n = 0; 

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                n *= (c - '0');
            } else {
                n++;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                
                n /= (ch - '0');
                k %= n;
            } else {
                if (k == 0 || n == k) {
                    return String.valueOf(ch);
                }
                n--;
            }
        }

        return "";
    }
}