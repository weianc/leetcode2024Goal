class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            // -(n+1) == MAX
            return myPow(1/x, Integer.MAX_VALUE) / x; 
        }
        if(n < 0){
            return myPow(1/x, -n);
        }

        if(n % 2 == 0){ // n是偶數: a^n = a^n/2 * a^n/2
            double sub = myPow(x, n/2);
            return sub * sub;
        }
        else {
            // n是奇數: a^n = a * a^(n-1)
            return x * myPow(x, n-1);
        }
        
    }
}