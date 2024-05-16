class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        Map<Integer, Integer> numToIndex = new HashMap<>();
        //int[] lastPosition = new int[10];

        for(int i = 0; i < digits.length; i++){
            int number = digits[i] - '0';
            //lastPosition[number] = i;
            // 如果同一個數字有2個位置，選擇最後的位置
            numToIndex.put(number, i);
        }

        for(int i = 0; i < digits.length; i++){
            int curNum = digits[i] - '0';
            // find from the numToIndex map to see if corresponding position > i
            for(int n = 9; n > curNum; n--){
                if(numToIndex.containsKey(n) && numToIndex.get(n) > i){
                    int largeNumIndex = numToIndex.get(n);
                    char tmp = digits[i];
                    digits[i] = digits[largeNumIndex];
                    digits[largeNumIndex] = tmp;
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }

        return num;
    }
}