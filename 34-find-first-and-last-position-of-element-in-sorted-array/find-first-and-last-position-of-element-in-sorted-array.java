class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find first target. 左界
        int left = 0;
        int right = nums.length-1;
        int leftIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if (nums[mid] == target){
                leftIndex = mid;
                right = mid - 1;
            }
            else {
                right = mid - 1;
            }
        }

        // find rightest target
        left = 0;
        right = nums.length-1;
        int rightIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid - 1;
            }
            else if (nums[mid] == target){
                rightIndex = mid;
                left = mid + 1;
            }
            else {
                left = mid + 1;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }
}