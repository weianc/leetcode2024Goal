class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        // On the same diagnal, the sum of indices are equal
        // [1]: {0, 0} reverse
        // [2]: {0, 1}, [4]{1, 0} 
        // [3]: {0, 2}, [5]{1, 1}, [7]{2, 0} reverse: from large to small
        // [6]: {1, 2}, [8]{2, 1}
        Map<Integer, List<Integer>> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[n*m];
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                int num = mat[r][c];
                if(!map.containsKey(r + c)){
                    map.put(r+c, new ArrayList<>());
                }
                List<Integer> tmp = map.get(r+c);
                tmp.add(num);
            }
        }

        // iterate through map and then build res
        int count = 0;
        for(Integer key : map.keySet()){
            List<Integer> numList = map.get(key);
            // if key % 2 == 0, reverse sequence
            if(key % 2 == 0){
                for(int i = numList.size() - 1; i >= 0; i--){
                    ans[count] = numList.get(i);
                    count++;
                }
            }
            else {
                for(int i = 0; i < numList.size(); i++){
                    ans[count] = numList.get(i);
                    count++;
                }
            }
        }
        return ans;
    }
}