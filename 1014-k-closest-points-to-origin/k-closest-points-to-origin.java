class Solution {
    // 1. Heap solution
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0]*b[0] + b[1]*b[1] - (a[0]*a[0] + a[1]*a[1]));
        int m = points.length;
        for(int i = 0; i < m; i++){
            int[] pos = points[i];
            int cur = pos[0] * pos[0] + pos[1] * pos[1];

            if(maxHeap.size() == k){
                int[] peakPos = maxHeap.peek();
                int peakVal = peakPos[0]* peakPos[0] + peakPos[1] * peakPos[1];
                if(peakVal > cur){
                    maxHeap.poll();
                    maxHeap.add(pos);
                }
            }
            else {
                maxHeap.add(pos);
            }
        }
        
        // find k smallest
        int count = 0;
        while(!maxHeap.isEmpty()){
            res[count] = maxHeap.poll();
            count++;
        }
        return res;
    }
}