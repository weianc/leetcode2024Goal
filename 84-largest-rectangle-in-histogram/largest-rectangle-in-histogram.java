class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack();
        int leftbound = -1;
        int rightbound = heights.length;
        int maxArea = 0;
        int[] lb = new int[heights.length];
        int[] rb = new int[heights.length];
        
        // calculate lb
        for(int i = 0; i < heights.length; i++){
            if(stk.isEmpty()){
                lb[i] = leftbound;
            }
            else {
                int cur = heights[i];
                while(!stk.isEmpty() && heights[stk.peek()] >= cur){
                    stk.pop();
                }
                lb[i] = stk.isEmpty() ? leftbound : stk.peek();
            }
            stk.push(i);
        }

        // reset Stack
        stk.clear();
        // calculate rb
        for(int i = heights.length - 1; i >= 0; i--){
            if(stk.isEmpty()){
                rb[i] = rightbound;
            }
            else {
                int cur = heights[i];
                while(!stk.isEmpty() && heights[stk.peek()] >= cur){
                    stk.pop();
                }
                rb[i] = stk.isEmpty() ? rightbound : stk.peek();
            }
            stk.push(i);
        }

        // calculate total largest area
        for(int i = 0; i < heights.length; i++){
            int w = rb[i] - lb[i] - 1;
            maxArea = Math.max(maxArea, w * heights[i]);
        }
        return maxArea;
    }
}