class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double globalMax = Integer.MIN_VALUE; 
        double sum = 0;
        
        // 同向雙指針
        // 1. 初始化左指針(窗口左界)
        int left = 0;
        // 初始化右指針為0(窗口右界)
        int right = 0;

        while(left <= right && right < nums.length){
            // 2. 擴增窗口
            sum += nums[right];
            right++;
            // 3. 縮小窗口
            while(right - left >= k){
                if(right - left == k){
                    globalMax = Math.max(globalMax, sum/k);
                }
                sum -= nums[left];
                left++;
            }
        }

        return globalMax;
    }
}