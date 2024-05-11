class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        // 1. 統計valToFreq map
        Map<Integer, Integer> valToFreq = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            valToFreq.put(nums[i], valToFreq.getOrDefault(nums[i], 0) + 1);
        }
        
        // 2. 根據valToFreq的結果找出frequency as a key
        // 做出freqToVal的map
        List<Integer>[] freqToVals = new ArrayList[nums.length + 1];
        for(Integer num : valToFreq.keySet()){
            int freq = valToFreq.get(num);
            if(freqToVals[freq] == null){
                freqToVals[freq] = new ArrayList<>();
            }
            freqToVals[freq].add(num);
        }

        // 3. 根據freqToValues找出top k freqent element. 從頻率大到小
        int p = 0;
        int[] res = new int[k];
        for(int i = nums.length; i >= 0; i--){
            if(p >= k){
                break;
            }
            List<Integer> list = freqToVals[i];
            if(list != null){
                for(int j = 0; j < list.size(); j++){
                    res[p] = list.get(j);
                    p++;
                    if(p >= k) break;
                }
            }
        }
        return res;
        
        
        
    }

    // private int quickSelect(int start, int end, int target){
    //     int pivot = partition(start, end);
    //     int pivot_val = unique[pivot];
    //     int target_val = unique[target];
    //     if(valToFreq.get(pivot_val) == valToFreq.get(target_val)){
    //         return pivot;
    //     }
    //     else if (valToFreq.get(pivot_val) < valToFreq.get(target_val)){
    //         // pivot頻率太小，把select範圍往右移
    //         return quickSelect(pivot+1, end, target);
    //     }
    //     else {
    //         // pivot頻率太大，把select範圍往左移
    //         return quickSelect(start, pivot - 1, target);
    //     }
    // }

    // private int partition(int start, int end){
    //     int p = start;
    //     int i = start + 1;
    //     int j = end;
    //     int p_val = unique[p];
        
    //     while(i <= j){
    //         // find and move valToFreq[e] larger than valToFre[pivot] to right
    //         // translate index into value
    //         // The following is incorrect. Because unique[i] and unique[j] is not static
    //         // int i_val = unique[i];
    //         // int j_val = unique[j];
            
    //         while(i <= end && valToFreq.get(unique[i]) <= valToFreq.get(p_val)){
    //             i++;
    //         }

    //         // find and move element smaller than pivot to left
    //         while(j > start && valToFreq.get(unique[j]) > valToFreq.get(p_val)){
    //             j--;
    //         }

    //         if(i > j){ // this means nothing to swap
    //             break;
    //         }
    //         // nums[i] > nums[p] && nums[j] < nums[p]
    //         swap(i, j);
    //     }
    //     // At the end of the operation
    //     // nums[j] must <= pivot 
    //     // switch j and p
    //     swap(j, p);
    //     // becaue j and p switch their position
    //     // we should return j
    //     return j;
    // }

    // private void swap(int i, int j){
    //     int tmp = unique[i];
    //     unique[i] = unique[j];
    //     unique[j] = tmp;
    // }
}