class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        List<Integer> al = new ArrayList<>();
        for(int i: arr){
            al.add(i);
        }
        Collections.sort(al);
        int k = al.get(al.size()-1);
        for(int i =0;i<arr.length;i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }
}