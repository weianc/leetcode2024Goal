class Solution {
    public int longestOnes(int[] nums, int k) {
        // 最長子陣列問題通常會使用滑動窗口解決
        int left = 0;
        int right = 0;
        int sum = 0;
        int globalMax = 0;
        // shrink window condition: right - left > k + sum
        while(right < nums.length){
            // 1. enlarge window size
            if(nums[right] == 1){
                sum++;
            }
            right++;

            // 2. shrink window
            // need to increase left pointer
            while(right - left > k + sum){
                if(nums[left] == 1){
                    sum--;
                }
                left++;
            }
            // update global res
            globalMax = Math.max(globalMax, right - left);
        }
        return globalMax;
    }
}