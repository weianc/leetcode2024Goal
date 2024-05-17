class Solution {
    // Solution 2: binary search
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length-1;

        // the answer is between arr[right] and arr[right]
        while(l <= r){
            int mid = l + (r - l)/2;
            // missing before mid smaller than k
            if(arr[mid] - (mid + 1) < k){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        // l = r + 1
        // r is the index which arr[r] - r - 1 < k
        // int remaining = k -(arr[r] - r - 1);
        return l + k;
    }
}