class Solution {
    int max_LIS = 1;
    // Solution 1: Top Down
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // save answer ends with index i
        int[] memo = new int[n];
        
        for(int i = 0; i < nums.length; i++){
            max_LIS = Math.max(max_LIS, helper(nums, i, memo));
        }
        return max_LIS;
    }

    private int helper(int[] nums, int end, int[] memo){
        // base case
        if(end == 0){
            return 1;
        }
        if(memo[end] != 0){
            return memo[end];
        }
        int ans = 1;
        // find answer from arr[i,  end]
        // arr[end-1, end], arr[end-2, end], arr[end-3, end] ... 
        for(int i = end - 1; i >= 0; i--){
            // 0, 1, 2, 3, .., end
            if(nums[i] < nums[end]){
                // 表示遞增
                ans = Math.max(ans, helper(nums, i, memo) + 1);
            }
        }
        // save into memoization table before return
        memo[end] = ans;
        return ans;
    }
}