class Solution {
    public int[] nextGreaterElements(int[] nums) {
         Deque<Integer> st=new LinkedList<>();
        int n=nums.length;
        int[] a=new int[n];
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i])
                st.pop();
            st.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i])
                st.pop();
            if(st.isEmpty())
                a[i]=-1;
            else
                a[i]=st.peek();
            st.push(nums[i]);
        }
        return a;
    }
}