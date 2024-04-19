class Solution {
    // Solution 2: two pointer to find next large permutation
    public void nextPermutation(int[] nums) {
        // iterate from bottom of the num.
        // because we want to find next large permutation. 
        // we should start from small digit (back)
        int i = 0;
        for(i = nums.length-2; i >= 0; i--){
            // 1. nums[i] >= nums[i+1]: 升序無法提供下個最大值
            // 2. nums[i] < nums[i+1]: 找到降序點，可以提供下個最大值
            if(nums[i] < nums[i+1]){
                break;
            }
        }
        // 例外 找不到降序點，ex. [3,2,1]
        if(i < 0){
            reverse(nums, 0, nums.length-1);
            return;
        }

        // 當前nums[i] < nums[i-1]
        // iterate from end of array to find index j which nums[j] > nums[i]
        // swap(i, j)
        // reverse(i+1, end);
        for(int j = nums.length-1; j > i; j--){
            if(nums[j] > nums[i]){
                swap(nums, i, j);
                reverse(nums, i+1, nums.length-1);
                break;
            }
        }
    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}