class Solution {
    public int visibleMountains(int[][] peaks) {
        // Transform the array to store left and right coordinates of peaks
        int[][] transformedPeaks = new int[peaks.length][2];
         Map<String, Integer> map = new HashMap<>();
         // Iterate over sorted peaks and count the number of visible peaks
         for(int i = 0; i < peaks.length; i++){
            int[] p = peaks[i];
            transformedPeaks[i] = new int[]{p[0] - p[1], p[0] + p[1]};
            int left = p[0] - p[1];
            int right = p[0] + p[1];
            String key = left + ":" + right;
            if(!map.containsKey(key)){
                map.put(key, 0);
            }
            map.put(key, map.get(key) + 1);
         }
        // sort by start position x - y, if start position is the same 
         // then sort by end position
         // x = p[0], y = p[1]
         Arrays.sort(transformedPeaks, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
         // maintain current max [x-y, x + y] intervals
         // any upcoming interval if end < curEnd. Then continue
         int maxEnd = Integer.MIN_VALUE;
         int visible = 0;
         for (int i = 0; i < transformedPeaks.length; i++) {
            int[] p = transformedPeaks[i];
            if (p[1] > maxEnd) {
                maxEnd = p[1];
                String curKey = p[0] + ":" + p[1];
                if (map.get(curKey) == 1) {
                    visible++;
                }
            }
        }
        return visible;
    }
}