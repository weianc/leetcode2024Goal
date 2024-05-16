class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        // Handle the range before the first element
        if (nums.length == 0) {
            // If there are no numbers, the missing range is the whole range
            result.add(Arrays.asList(lower, upper));
            return result;
        }
        
        // Handle the initial missing range
        if (nums[0] > lower) {
            result.add(Arrays.asList(lower, nums[0] - 1));
        }
        
        // Handle the missing ranges between the numbers
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                result.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        
        // Handle the missing range after the last element
        if (nums[nums.length - 1] < upper) {
            result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));
        }
        
        return result;
    }
}