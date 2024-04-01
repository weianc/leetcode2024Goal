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

        if(intervals.length <= 1){
            return intervals;
        }
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            int[] intv = intervals[i];
            int[] prev = {start, end};
            // safely assume start1 <= start2
            // 1. merge: intv[1] <= end
            if(intv[1] < end){
                // current interval completely included. Can be added to result
            } 
            // intv[1] > end
            else if(intv[0] > end){
                // not overlap. Update start and end
                // add previous interval to res
                res.add(prev);
                start = intv[0];
                end = intv[1];
            }
            else { // intv[0] < end
                // overlap but not covered, update end with intv[1]
                end = intv[1];
            }
            if(i == intervals.length - 1){
                int[] cur = {start, end};
                res.add(cur);
            }
        }

        
        
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}