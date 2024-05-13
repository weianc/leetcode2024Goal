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

        // for(int i = 0; i < psum.length; i++){
        //     // 計算need，找出psum[i] % k已經在hashmap中出現過的結果
        //     // 因為可以得出一樣的餘數表示數字相差是k*n，(psum[j]-psum[i])%k = 0
        //     int need = psum[i] % k; 
        //     if(psumModKToIndex.containsKey(need)){
        //         int index = psumModKToIndex.get(need);
        //         // 並且計算出pSum index差值至少是2
        //         int length = Math.abs(index - i);
        //         if(length >= 2){
        //             return true;
        //         }
        //     }
        // }
        return false;
    }
}