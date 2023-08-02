class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void solve(List<Integer> l,List<List<Integer>> res,int[] nums){
        if(l.size() == nums.length){
            res.add(new ArrayList<>(l));
            return;
        }
        for(int n : nums){
            if(!l.contains(n)){
                l.add(n);
                solve(l,res,nums);
                l.remove(l.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<>();
        solve(l,res,nums);
        return res;
    }
}