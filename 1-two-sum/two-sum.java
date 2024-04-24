class Solution {
    public int[] twoSum(int[] nums, int target) {
        // one pass hash table
        // if there is key for remain value -> directly return
        // otherwise add to map
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int remain = target - nums[i];
            if(map.containsKey(remain) && map.get(remain) != i){
                return new int[]{i, map.get(remain)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}