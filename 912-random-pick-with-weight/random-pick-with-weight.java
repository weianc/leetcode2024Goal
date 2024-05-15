class Solution {
    // sum , index
    private TreeMap<Integer, Integer> segment = new TreeMap<>();
    private int sum = 0;

    public Solution(int[] w) {
        for(int i = 0; i < w.length; i++){
            sum += w[i];
            segment.put(sum, i);
        }
    }
    
    public int pickIndex() {
        Random rnd = new Random();
        // range [1, sum]
        int randomNum = 1 + rnd.nextInt(sum);
        int startBound = this.segment.ceilingKey(randomNum);
        return this.segment.get(startBound);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */