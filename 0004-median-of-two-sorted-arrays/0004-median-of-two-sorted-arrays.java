class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] a = new int[n+m];
        for(int i=0;i<n;i++){
            a[i] = nums1[i];
        }
        for(int i=0;i<m;i++){
            a[n+i] = nums2[i];
        }
        Arrays.sort(a);
        int low = 0;
        int high = a.length-1;
        int mid = (low + high)/2;
        if(a.length%2 == 0){
            double c = a[mid];
            double d = a[mid+1];
            double b = (c+d)/2;
            return b;
        }
        return a[mid];
    }
}