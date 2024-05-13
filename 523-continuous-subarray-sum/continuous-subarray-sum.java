class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // nums = [23, 2, 4, 6, 7]
        // prefixSum = [0, 23, 25, 29, 35, 42]
        // PSum[3] - PSum[1] = 29 - 23 = 6 (sum[1,2])
        // Sum[0,3] - Sum[0,1]
        // prefixSum%k vs 索引的映射
        Map<Integer, Integer> psumModKToIndex = new HashMap<>();
        // 1. create prefixSum
        int[] psum = new int[nums.length + 1];
        for(int i = 1; i < psum.length; i++){
            psum[i] = psum[i-1] + nums[i-1];
        }

        for(int i = 0; i < psum.length; i++){
            int val = psum[i] % k;
            if(!psumModKToIndex.containsKey(val)){
                psumModKToIndex.put(val, i);
            }
            else {
                // 表示相同餘數的psum出現
                if(i - psumModKToIndex.get(val) >= 2){
                    return true;
                }
            }
        }
        return false;
    }
}