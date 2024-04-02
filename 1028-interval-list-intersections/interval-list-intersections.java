class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // use i, j pointer to indicate which interval we are processing
        int i = 0;
        int j = 0;
        int len1 = firstList.length;
        int len2 = secondList.length;
        List<int[]> res = new ArrayList<>();

        while(i < len1 && j < len2){
            int[] intv1 = firstList[i];
            int[] intv2 = secondList[j];
            handleOverlap(intv1, intv2, res);
            // after handling, need to advance i or j
            if(intv1[1] < intv2[1]){
                // advance intv1
                i++;
            }
            else if (intv1[1] > intv2[1]) {
                j++;
            }
            else {
                i++;
                j++;
            }
        }
        int[][] ans = res.toArray(new int[res.size()][2]);
        return ans;
    }

    private void handleOverlap(int[] intv1, int[] intv2, List<int[]> res){
        int s1 = intv1[0];
        int e1 = intv1[1];
        int s2 = intv2[0];
        int e2 = intv2[1];
        if(e1 < s2 || e2 < s1){
            // no overlap
            return;
        }

        int coverStart = Math.max(s1, s2);
        int coverEnd = Math.min(e1, e2);
        int[] coverInterval = {coverStart, coverEnd};
        res.add(coverInterval);
    }
}