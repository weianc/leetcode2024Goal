class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> idxList = new ArrayList<>();
        int maxHeight = -1; // This is to compare with end of the array
        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > maxHeight){
                idxList.add(i);
                // update maxHeight
                maxHeight = heights[i];
            }
        }

        int n = idxList.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = idxList.get(n-1-i);
        }
        return ans;

    }
}