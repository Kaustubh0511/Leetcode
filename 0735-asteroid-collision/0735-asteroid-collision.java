class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i : asteroids){
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && i < 0)) {
                if(Math.abs(st.peek()) < Math.abs(i)){
                    st.pop();
                    continue;
                }
                else if(Math.abs(st.peek()) == Math.abs(i)){
                    st.pop();
                }
                flag = false;
                break;
            }
            if(flag){
                    st.push(i);
            }
        }
        int[] res = new int[st.size()];
        for(int i =st.size()-1;i>=0;i--){
            res[i] = st.peek();
            st.pop();
        }
        return res;
    }
}