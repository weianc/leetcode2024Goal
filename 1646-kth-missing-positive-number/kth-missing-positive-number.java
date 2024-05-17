class Solution {
    // Solution: linear search
    // [2, 3, 4, 6, 11]
    public int findKthPositive(int[] arr, int k) {
        int j = 0;
        int n = arr.length;
        int curNum = 1;
        int count = 0;
        while(count < k && j < n){
            if(curNum == arr[j]){
                // count do not need to move
                j++;
            }
            else {
                // means that curNum is missing from arr
                count++;
            }

            // check count == k or not 
            if (count == k) return curNum;
            curNum++;
        }

        // arr is done but k is not yet reached
        // k - count: number that missing from array
        return curNum - 1+ k - count;
    }
}