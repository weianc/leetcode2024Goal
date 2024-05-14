class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1; 
        if(n == Integer.MIN_VALUE) {
            // 會多乘一次
            return myPow(1/x, Integer.MAX_VALUE) / x;
        }
        if(n < 0) return myPow(1/x, -n);
        if(n % 2 == 0) {
            double sub = myPow(x, n/2);
            return sub * sub;
        }
        else {
            return myPow(x, n-1) * x;
        }
    }
}