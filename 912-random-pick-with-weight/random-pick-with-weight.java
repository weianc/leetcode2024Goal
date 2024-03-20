class Solution {
    // position, index
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
        int randomNum = rnd.nextInt(sum); // sum must larger than 0
        //System.out.println(randomNum);
        //int startBound = this.segment.floorKey(randomNum);
        Integer endBound = this.segment.higherKey(randomNum);
        return this.segment.get(endBound);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */