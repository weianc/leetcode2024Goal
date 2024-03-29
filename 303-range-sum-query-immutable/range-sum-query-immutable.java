class NumArray {
    private int[] preSum;
    public NumArray(int[] nums) {
        // preSum[0] = 0
        this.preSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */