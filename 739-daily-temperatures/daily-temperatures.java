class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack();
        for(int i = n-1; i >= 0; i--){
            while(!stk.isEmpty() && temperatures[i] >= temperatures[stk.peek()]){
                stk.pop();
            }
            // need to wait for stk.peek() - i
            ans[i] = stk.isEmpty() ? 0 : stk.peek() - i;
            stk.push(i);
        }

        return ans;
    }
}