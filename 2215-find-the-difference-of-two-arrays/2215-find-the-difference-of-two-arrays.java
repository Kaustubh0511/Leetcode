class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for(int num:nums1){
            hs1.add(num);
        }
        for(int num:nums2){
            hs2.add(num);
        }
        List<Integer> d1 = new ArrayList<>(hs1);
        d1.removeAll(hs2);
        List<Integer> d2 = new ArrayList<>(hs2);
        d2.removeAll(hs1);
        List<List<Integer>> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        return list;
    }
}