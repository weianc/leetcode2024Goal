class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }

        int i = 0;
        while(!pq.isEmpty() && i < k){
            int[] cur = pq.poll();
            res[i++] = cur[0];
        }
        return res;
        
    }
}