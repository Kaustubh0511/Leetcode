class Solution {
    public double time(int[] dist,int s){
        double t = 0.0;
        for(int i =0;i<dist.length;i++){
            double r = (double) dist[i] /(double) s;
            t += (i == dist.length-1 ? r : Math.ceil(r));
        }
        return t;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10000000;;
        int speed = -1;
        while(low <= high){
            int mid =  (low+high)/2;
            if(time(dist,mid) <= hour){
                speed = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        }
        return speed;
    }
}