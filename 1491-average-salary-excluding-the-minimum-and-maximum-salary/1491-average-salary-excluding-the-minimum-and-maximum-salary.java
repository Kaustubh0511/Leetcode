class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double sal =0;
        double count =0;
        Arrays.sort(salary);
        for(int i=1;i<n-1;i++){
            sal += salary[i];
            //System.out.println(sal);
            count++;
            //System.out.println(count);
        }
        double avg = sal/count;
        return avg;
    }
}