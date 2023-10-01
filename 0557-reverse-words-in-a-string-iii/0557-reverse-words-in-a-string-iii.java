class Solution {
    public String reverseWords(String s) {
         String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String value : str) {
            StringBuilder stb = new StringBuilder(value);
            stb.reverse();
            String re = stb.toString();
            sb.append(re).append(" ");
        }
        return sb.toString().trim();
    }
}