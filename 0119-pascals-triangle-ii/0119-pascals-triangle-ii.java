class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> li = new ArrayList<>();
        for(int i= 0;i<=n;i++){
            li.add(1);
            for(int j = i-1;j>0;j--){
                li.set(j,li.get(j)+li.get(j-1));
            }
            // li.add(1);
        }
        
        return li;
    }
}