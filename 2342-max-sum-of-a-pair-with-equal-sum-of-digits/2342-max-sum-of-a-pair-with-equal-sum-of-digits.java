class Solution {
    public int sum(int number){
        int sum = 0, digit =0;
        while(number > 0)  
            {     
            digit = number % 10; 
            sum = sum + digit;  
            number = number / 10;  
            }
        return sum;
        }
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for (int item : nums) {
            int key = sum(item);

            if (!map.containsKey(key))
                map.put(key, item);
            else {
                result = Math.max(result, map.get(key) + item);
                map.put(key, Math.max(map.get(key), item));
            }
        }

        return result;
    }
}