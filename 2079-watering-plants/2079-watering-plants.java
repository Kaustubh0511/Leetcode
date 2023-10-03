class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int n = plants.length;
        int curCap = capacity;
         for(int i=0;i<plants.length;i++) {
            if(capacity>=plants[i]){
                capacity -= plants[i];
                steps++;
            }else{
                steps += 2*i;
                capacity = curCap;
                i--;

            }
        }
        return steps;
    }
}