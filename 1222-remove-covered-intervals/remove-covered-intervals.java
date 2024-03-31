class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 1. 按照起點升序排列
        // 2. 起點相同，降序排列
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        // count if interval is not covered by the previous one;
        int count = 0;
        int prev_end = 0;
        for(int i = 0; i < intervals.length; i++){
            // safely assume start1 <= start2
            int[] cur = intervals[i];
            // current is not covered by previous
            if(prev_end < cur[1]){
                count++;
                // update prev_end because previous interval is not possible
                // to cover more intervals
                prev_end = cur[1];
            }
            else {
                // current interval is covered by previous interval
                // previous interval can cover more invervals.
                // so keep previous_end position
            }
        }
        return count;
    }
}