class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastPosition = new int[10];

        for(int i = 0; i < digits.length; i++){
            int number = digits[i] - '0';
            lastPosition[number] = i;
        }

        for(int i = 0; i < digits.length; i++){
            int curNum = digits[i] - '0';
            for(int n = 9; n > curNum; n--){
                if(lastPosition[n] > i){
                    char tmp = digits[i];
                    digits[i] = digits[lastPosition[n]];
                    digits[lastPosition[n]] = tmp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}