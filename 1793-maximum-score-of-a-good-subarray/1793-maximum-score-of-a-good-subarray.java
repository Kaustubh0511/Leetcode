class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int res = solve(nums, k);
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
        
        return Math.max(res, solve(nums, n - k - 1));
    }
    
    public int solve(int[] nums, int k) {
        int n = nums.length;
        int l[] = new int[k];
        int min = Integer.MAX_VALUE;
        for (int i = k - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            l[i] = min;
        }
        
        List<Integer> r = new ArrayList();
        min = Integer.MAX_VALUE;
        for (int i = k; i < n; i++) {
            min = Math.min(min, nums[i]);
            r.add(min);
        }
        
        int res = 0;
        for (int j = 0; j < r.size(); j++) {
            min = r.get(j);
            int i = BS(l, min);
            int size = (k + j) - i + 1;
            res = Math.max(res, min * size);
        }

        return res;
    }
    
    public int BS(int[] nums, int num) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}