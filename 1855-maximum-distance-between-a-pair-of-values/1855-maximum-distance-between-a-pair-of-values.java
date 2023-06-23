class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int diff =0;
           int p1 =0;
            int p2 = 0;
        while(p1<nums1.length && p2<nums2.length){
            if(nums2[p2] >= nums1[p1]){
                diff = p2 -p1;
                max = Math.max(max,diff);
                p2++;
            }
            else{
                p1++;
            }
            
        }
        return max;
    }
}