class Solution {
    public int countVowelPermutation(int n) {
        final int mod = (int)1e9+7;
        
        long cA = 1, cE = 1,cI = 1,cO = 1,cU = 1;
        
        for(int j = 1;j<n;j++){
            long ncA = cE;
            long ncE = (cA + cI)%mod;
            long ncI = (cA + cE + cO +cU)%mod;
            long ncO = (cI + cU)%mod;
            long ncU = cA;
            
            
            cA = ncA;
            cE = ncE;
            cI = ncI;
            cO = ncO;
            cU = ncU;
        }
        
        long res = (cA + cE + cI + cO + cU)%mod;
        
        return (int)res;
    }
}