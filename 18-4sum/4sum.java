class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 1. 数组得排个序
        Arrays.sort(nums);
        // 2. 窮舉4sum的開頭
        for(int i = 0; i < nums.length; i++){
            long targetForThreeSum = target - nums[i];
            // 3. 注意我们把 threeSumTarget 函数签名中的 target 变量设置为 long 类型，
            // 因为本题说了 nums[i] 和 target 的取值都是 [-10^9, 10^9]，int 类型的话会造成溢出。
            List<List<Integer>> threeSumRes = threeSum(nums, i+1, targetForThreeSum);

            // add nums[i] to tuples
            for(List<Integer> tuples : threeSumRes){
                tuples.add(nums[i]);
                res.add(tuples);
            }

            // de-duplicate
            while(i < nums.length - 1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] nums, int start, long target){
        List<List<Integer>> threeSumRes = new ArrayList<>();
        for(int i = start; i < nums.length; i++){
            long twoSumTarget = target - nums[i];
            List<List<Integer>> twoSumRes = twoSum(i + 1, nums, twoSumTarget);

            // add nums[i] to twoSumRes;
            for(List<Integer> pair : twoSumRes){
                pair.add(nums[i]);
                threeSumRes.add(pair);
            }

            // de-duplicate
            // nums[i] = -1, nums[i+1] = -1
            while(i < nums.length - 1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return threeSumRes;
    }

    private List<List<Integer>> twoSum(int start, int[] nums, long target){
        List<List<Integer>> twoSumRes = new ArrayList<>();
        int end = nums.length - 1;
        while(start < end){
            int startNum = nums[start];
            int endNum = nums[end];
            if(nums[start] + nums[end] > target){
                end--;
            }
            else if (nums[start] + nums[end] < target){
                start++;
            }
            else {
                // add to res
                List<Integer> pair = new ArrayList<>();
                pair.add(startNum);
                pair.add(endNum);
                twoSumRes.add(pair);
                while(start < end && nums[start] == startNum){
                    start++;
                }
                while(start < end && nums[end] == endNum){
                    end--;
                }
            }
        }
        return twoSumRes;
    }
}