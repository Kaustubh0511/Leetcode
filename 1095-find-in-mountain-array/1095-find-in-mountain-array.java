/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        int l = 0;
        int h = n - 2;
        
        while(l != h){
            int mid = (l+h)/2;
            
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        
        int p = l;
        l = 0;
        h = p;
        
        while(l != h){
            int mid = (l+h)/2;
            
            if(mountainArr.get(mid) < target){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        
        if(mountainArr.get(l) == target){
            return l;
        }
        
        l = p + 1;
        h = n - 1;
        
        while(l != h){
            int mid = (l+h)/2;
            
            if(mountainArr.get(mid) > target){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        
        if(mountainArr.get(l) == target){
            return l;
        }
        
        return -1;
    }
}