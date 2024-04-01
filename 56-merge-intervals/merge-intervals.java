class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // 1. sort according to interval start
        // 2. if interval the same, sort according to end
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        if(intervals.length <= 1) return intervals;
        // only update last item when max end point has been changed.
        // add the first item into res
        res.add(intervals[0]);
        for(int i = 0; i < intervals.length; i++){
            int[] last = res.get(res.size()-1);
            int[] cur = intervals[i];
            // check if current intv end is larger than last interval end
            // overlap situation. merge
            if(cur[0] <= last[1]){
                // modify last to include
                last[1] = Math.max(cur[1], last[1]);
            }
            else {
                // no overlap, cur[0] > last[1]
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}