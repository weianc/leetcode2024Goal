class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 先把nums1中的元素index放入最小堆當中
        // 然後再pop最小的combination, 找出當前index2後面元素
        // 放入最小堆當中
        // 如此一來可以保證比較次數最少
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]])-(nums1[b[0]] + nums2[b[1]]));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            pq.offer(new int[]{i, 0});
        }

        // Pick only top k smallest
        while(k > 0 && !pq.isEmpty()){
            int[] cur = pq.poll();
            int index1 = cur[0];
            int index2 = cur[1];
            // add to the result
            Integer[] num = {nums1[index1], nums2[index2]};
            ans.add(Arrays.asList(num));
            k--;
            if(index2 < nums2.length-1){
                index2++;
                pq.offer(new int[]{index1, index2});
            }
        }
        return ans;
    }
}