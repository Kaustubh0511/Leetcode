class Solution {
    public boolean isAnagram(String s, String t) {
        int n = t.length();
        char[] ch1 = t.toCharArray();
        char[] ch2 = s.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String a = new String(ch1);
        String b = new String(ch2);
        
        if(b.equals(a)){
            return true;
        }
        return false;
    }
}