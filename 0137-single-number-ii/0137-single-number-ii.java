class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int two = 0;
        int cbm;

        for(int i=0;i<nums.length;i++){
            two = two | (ones & nums[i]);
            ones = ones ^ nums[i];

            cbm = ~(ones&two);

            ones &= cbm;
            two &= cbm;
        }
        return ones;
    }
}