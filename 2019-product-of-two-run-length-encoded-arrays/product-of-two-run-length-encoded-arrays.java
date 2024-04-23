class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> prodNums = new ArrayList<>();
        
        int i = 0, j = 0; // Encoded1 和 Encoded2 的索引
        int m = encoded1.length, n = encoded2.length;

        int prevProdNum = -1; // 上一個產品數
        int count = 0; // 用於計算連續相同產品數的計數器

        while (i < m && j < n) {
            int num1 = encoded1[i][0], freq1 = encoded1[i][1];
            int num2 = encoded2[j][0], freq2 = encoded2[j][1];
            int curProdNum = num1 * num2; // 目前的產品數

            // 更新迴圈索引
            int minFreq = Math.min(freq1, freq2);
            encoded1[i][1] -= minFreq;
            encoded2[j][1] -= minFreq;
            if (encoded1[i][1] == 0) i++;
            if (encoded2[j][1] == 0) j++;

            // 更新結果
            if (curProdNum == prevProdNum) {
                count += minFreq;
            } else {
                if (prevProdNum != -1) {
                    prodNums.add(Arrays.asList(prevProdNum, count));
                }
                prevProdNum = curProdNum;
                count = minFreq;
            }
        }

        // 將最後一個結果添加到列表中
        if (prevProdNum != -1) {
            prodNums.add(Arrays.asList(prevProdNum, count));
        }

        return prodNums;
    }
}
