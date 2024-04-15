class Solution {
    int[] unique;
    Map<Integer, Integer> valToFreq = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        for(int i = 0; i < nums.length; i++){
            valToFreq.put(nums[i], valToFreq.getOrDefault(nums[i], 0) + 1);
        }
        
        int i = 0;
        unique = new int[valToFreq.size()];
        for(Integer num : valToFreq.keySet()){
            unique[i] = num;
            i++;
        }
        
        // 從unique array 最後面往前數k個
        int target = unique.length - k; 
        int ansIdx = quickSelect(0, unique.length - 1, target);

        // for(int j = unique.length - 1; j >= ansIdx; j--){
        //     res[j] = unique[j];
        // }

        return Arrays.copyOfRange(unique, target, unique.length);
        
    }

    // target is valToFreq[e]
    private int quickSelect(int start, int end, int target){
        int pivot = partition(start, end);
        int pivot_val = unique[pivot];
        int target_val = unique[target];
        if(valToFreq.get(pivot_val) == valToFreq.get(target_val)){
            return pivot;
        }
        else if (valToFreq.get(pivot_val) < valToFreq.get(target_val)){
            // pivot頻率太小，把select範圍往右移
            return quickSelect(pivot+1, end, target);
        }
        else {
            // pivot頻率太大，把select範圍往左移
            return quickSelect(start, pivot - 1, target);
        }
    }

    private int partition(int start, int end){
        int p = start;
        int i = start + 1;
        int j = end;
        int p_val = unique[p];
        
        while(i <= j){
            // find and move valToFreq[e] larger than valToFre[pivot] to right
            // translate index into value
            // The following is incorrect. Because unique[i] and unique[j] is not static
            // int i_val = unique[i];
            // int j_val = unique[j];
            
            while(i <= end && valToFreq.get(unique[i]) <= valToFreq.get(p_val)){
                i++;
            }

            // find and move element smaller than pivot to left
            while(j > start && valToFreq.get(unique[j]) > valToFreq.get(p_val)){
                j--;
            }

            if(i > j){ // this means nothing to swap
                break;
            }
            // nums[i] > nums[p] && nums[j] < nums[p]
            swap(i, j);
        }
        // At the end of the operation
        // nums[j] must <= pivot 
        // switch j and p
        swap(j, p);
        // becaue j and p switch their position
        // we should return j
        return j;
    }

    private void swap(int i, int j){
        int tmp = unique[i];
        unique[i] = unique[j];
        unique[j] = tmp;
    }
}