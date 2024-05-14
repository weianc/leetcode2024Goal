class MovingAverage {
    private int[] nums;
    private int cur;
    private int acc;
    private int capacity;
    public MovingAverage(int size) {
        this.nums = new int[size];
        this.cur = 0;
        this.acc = 0;
        this.capacity = 0;
    }
    
    public double next(int val) {
        // expand window
        int prevNum = nums[cur];
        nums[cur] = val;
        acc += nums[cur];
        if(capacity < nums.length){
            capacity++;
        }
        else {
            // should remove previous index
            acc -= prevNum;
        }
        
        // 當前指針到底的時候，要回頭
        if(cur == nums.length - 1){
            cur = 0;
        }
        else {
            cur++;
        }

        return (double) acc / capacity;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */