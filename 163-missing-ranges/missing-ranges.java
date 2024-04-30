class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<Integer> copy = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            List<Integer> range = new ArrayList<>();
            range.add(lower);
            range.add(upper);
            res.add(range);
            return res;
        }
        int n = nums.length;
        copy.add(lower);
        for(int i = 0; i < nums.length; i++){
            copy.add(nums[i]);
        }
        copy.add(upper);
        
        for(int i = 0; i < copy.size() - 1; i++){
            int cur = copy.get(i);
            int next = copy.get(i+1);

            if(cur + 1 == next && i != 0 && i != copy.size()-2 || cur == next) continue;
            List<Integer> range = new ArrayList<>();
            if(i == 0){
                range.add(cur);
            }
            else {
                range.add(cur + 1);
            }

            if(i == copy.size() - 2){
                range.add(next);
            }
            else {
                range.add(next - 1);
            }
            res.add(range);
        }
        return res;
    }
}