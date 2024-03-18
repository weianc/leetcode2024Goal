class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stk = new Stack();
        for(int i = heights.length - 1; i >= 0; i--){
            if(stk.isEmpty() || heights[i] > heights[stk.peek()]){
                stk.push(i);
            }
        }

        int[] ans = new int[stk.size()];
        int i = 0;
        while(!stk.isEmpty()){
            ans[i] = stk.pop();
            i++;
        }
        return ans;

    }
}