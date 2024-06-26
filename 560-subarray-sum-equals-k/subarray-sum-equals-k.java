class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0; 
        // 1. compose of hashmap
        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        int prefixSum = 0;
        prefixSumCountMap.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            // preSum[i+1] = preSum[i] + nums[i];
            prefixSum = prefixSum + nums[i];
            // 2. find all k - prefixSum = remain, if remain contains in map, then add to result
            if(prefixSumCountMap.containsKey(prefixSum - k)){
                res += prefixSumCountMap.get(prefixSum - k);
            }
            prefixSumCountMap.put(prefixSum, prefixSumCountMap.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }
}