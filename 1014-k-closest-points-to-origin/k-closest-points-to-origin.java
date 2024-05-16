class Solution {
    // 1. Heap solution
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a));
        int m = points.length;
        for(int i = 0; i < m; i++){
            int[] pos = points[i];
            int cur = distance(pos);

            if(maxHeap.size() == k){
                int[] peakPos = maxHeap.peek();
                int peakVal = distance(peakPos);
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
        // You may return the answer in any order.
        int count = 0;
        while(!maxHeap.isEmpty()){
            res[count] = maxHeap.poll();
            count++;
        }
        return res;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}