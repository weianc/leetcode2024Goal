class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        // iterate from left to right to find left max of index i
        int[] left = new int[n];
        int[] right = new int[n];
        int area = 0;
        // boundary
        // i = 0, left max is INF
        left[0] = height[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        right[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], height[i+1]);
        }

        // calculate trapping area: a[i] = Math.min(left[i], right[i])
        for(int i = 1; i <= n-2; i++){
            int h = Math.min(left[i], right[i]);
            if(h > height[i]){
                area += (h - height[i]);
            }
        }

        return area;
    }
}