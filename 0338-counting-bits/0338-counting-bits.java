class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0]=0;
        if(n>0){arr[1]=1;}
        if(n>1){
            int sum=2;
            for (int i =2;1<2;i*=2 ){
                for (int j=0;j<i;j++){
                    arr[i+j]=arr[j]+1;
                        sum++;
                    if(sum==n+1){
                        break;
                    }
                }
                
                if(sum==n+1){
                    break;
                }
            }
        } 
    return arr;

    }
}