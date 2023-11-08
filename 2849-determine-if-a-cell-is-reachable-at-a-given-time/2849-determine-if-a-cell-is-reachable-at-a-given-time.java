class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int wdt = Math.abs(sx - fx);
        int hgt = Math.abs(sy - fy);
        if (wdt == 0 && hgt == 0 && t == 1) {
            return false;
        }
        return t >= Math.max(wdt, hgt);
    }
}