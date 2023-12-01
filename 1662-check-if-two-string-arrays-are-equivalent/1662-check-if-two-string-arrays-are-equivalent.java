class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(String s : word1){
            sb1.append(s);
        }
        for(String s : word2){
            sb2.append(s);
        }
        
        String st1 = sb1.toString();
        String st2 = sb2.toString();
        return st1.equals(st2);
    }
}