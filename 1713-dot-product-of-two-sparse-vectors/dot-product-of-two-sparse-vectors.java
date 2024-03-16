class SparseVector {
    Map<Integer, Integer> vector;
    SparseVector(int[] nums) {
        this.vector = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                vector.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(Integer idx : this.vector.keySet()){
            if(vec.vector.containsKey(idx)){
                sum += this.vector.get(idx) * vec.vector.get(idx);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);