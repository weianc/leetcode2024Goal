class Solution {
    // position, index
    private TreeMap<Integer, Integer> segment = new TreeMap<>();
    private int sum = 0;

    public Solution(int[] w) {
        for(int i = 0; i < w.length; i++){
            segment.put(sum, i);
            sum += w[i];
        }
    }
    
    public int pickIndex() {
        Random rnd = new Random();
        if(sum == 0) {
            int key = segment.firstKey();
            return segment.get(key);
        }
        int randomNum = rnd.nextInt(sum);
        System.out.println(randomNum);
        int startBound = this.segment.floorKey(randomNum);
        //Integer endBound = this.segment.ceilingKey(randomNum);

        return this.segment.get(startBound);

        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */