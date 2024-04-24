class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 窮舉3 sum第一個數
        for(int i = 0; i < nums.length; i++){
            twoSum(i+1, nums.length-1, nums, -nums[i], res);
            // 跳過nums[i]重複的情況
            // ex: [-4, -1, -1, 0, 1, 2]
            // i == 1 and i == 2會產生重複的結果
            while(i < nums.length - 1 && nums[i] == nums[i+1]){
                i++;
            }
        }

        return res;
    }

    private List<List<Integer>> twoSum(int start, int end, int[] nums, int target, List<List<Integer>> res){
        int thirdIndex = start - 1;
        while(start < end){
            if(nums[start] + nums[end] > target){
                end--;
            }
            else if (nums[start] + nums[end] < target){
                start++;
            }
            else {
                // add the result first
                List<Integer> pair = new ArrayList<>();
                int numStart = nums[start];
                int numEnd = nums[end];
                pair.add(numStart);
                pair.add(numEnd);
                pair.add(nums[thirdIndex]);
                res.add(pair);
                
                // 跳过所有重复的元素
                while(start < end && nums[start] == numStart){
                    start++;
                }
                while(start < end && nums[end] == numEnd){
                    end--;
                }
            }
            
        }
        return res;
    }


}