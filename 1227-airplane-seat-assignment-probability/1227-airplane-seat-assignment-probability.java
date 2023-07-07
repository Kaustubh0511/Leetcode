class Solution {
    public double nthPersonGetsNthSeat(int n) {
        double r = 0.0;
        if(n == 1){
            r = 1.0;
        }
        else{
            r = 0.5;
        }
        return r;
    }
}