class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int i = nums1.length - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[i] = nums1[p1];
                p1--;
            }
            else {
                nums1[i] = nums2[p2];
                p2--;
            }
            i--;
        }

        //  不用考慮p1還沒到結尾的情況，因為我們本身就是在修改nums1
        while(p2 >= 0){
            nums1[i] = nums2[p2];
            p2--;
            i--;
        }
    }
}