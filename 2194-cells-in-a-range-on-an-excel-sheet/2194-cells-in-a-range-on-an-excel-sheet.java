class Solution {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        char sr = s.charAt(0);
        char sc = s.charAt(1);
        char er = s.charAt(3);
        char ec = s.charAt(4);
        
        while(sr <= er){
            while(sc <= ec){
                res.add(sr+""+sc);
                sc++;
            }
            sc = s.charAt(1);
            sr++;
        }
        return res;
    }
}