class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String[] words = s.trim().split("\\s+");
        String[] reverse = new String[words.length];
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1;i >= 0;i --){
            reverse[words.length - 1 - i] = words[i];
        }
        for(int i=0;i<reverse.length;i++){
            sb.append(reverse[i]+" ");
        }
        String rs = sb.toString();
        return rs.trim();
    }
}