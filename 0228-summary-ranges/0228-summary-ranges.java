class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        ArrayList<String> al =new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int j=nums[i];
            while(i+1<n && nums[i]+1==nums[i+1])
                i++;
            
            if(j!=nums[i]){
                al.add(""+j+"->"+nums[i]);
            }
            else{
                al.add(""+j);
            }
        }
        return al;
    }
}