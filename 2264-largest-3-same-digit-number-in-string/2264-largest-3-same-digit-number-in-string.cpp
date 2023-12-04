class Solution {
public:
    string largestGoodInteger(string num) {
        int n = num.length();
        char c = '\0';
        for(int i = 0;i<=n-3;i++){
            if(num[i] == num[i+1] && num[i] == num[i+2]){
                c = max(c,num[i]);
            }
        }
        
        return c == '\0' ? "" : string(3,c);
    }
};