class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        Stack<Integer> stk = new Stack();
        for(int i = prices.length - 1; i >= 0; i--){
            // 大於當前數字的全部彈出
            while(!stk.isEmpty() && prices[i] < stk.peek()){
                stk.pop();
            }
            res[i] = stk.isEmpty() ? prices[i] : prices[i] - stk.peek();
            stk.push(prices[i]);
        }
        return res;
    }
}