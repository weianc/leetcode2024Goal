class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 1. smallest k: k-1
        // 2. largest k: nums.length - k;
        int index = nums.length - k;
        int ans = quickSelect(nums, 0, nums.length-1, index);
        return nums[ans];
    }

    private int quickSelect(int[] nums, int start, int end, int index){
        int pivot = partition(nums, start, end);
        if(pivot == index){
            return pivot;
        }
        else if (pivot < index){
            // need to have more num left to pivot
            return quickSelect(nums, pivot+1, end, index);
        }
        else {
            // need to have more num right to pivot
            return quickSelect(nums, start, pivot-1, index);
        }
    }

    private int partition(int[] nums, int start, int end){
        int p = start;
        int i = start+1;
        int j = end;

        while(i <= j){
            while(i <= end && nums[i] <= nums[p]){
                i++;
            }
            // at this time, nums[i] > pivot
            while(j > start && nums[j] > nums[p]){
                j--;
            }
            // at this time, nums[j] <= pivot
            if(i > j){
                break;
            }
            // exchange i and j position
            swap(nums, i, j);
        }
        // At the end of the operation
        // nums[j] must <= pivot 
        // switch j and p
        swap(nums, j, p);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} 