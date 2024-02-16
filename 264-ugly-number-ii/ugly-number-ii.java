class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 0, p3 = 0, p5 = 0;
        int product2 = 1;
        int product3 = 1;
        int product5 = 1;
        int p = 0; // 表示當前指針的值
        while(p < n){
            int min = Math.min(product2, Math.min(product3, product5));
            // check current min match with which product. Then move the pointer
            ugly[p] = min;
            p++;
            //System.out.println(min);
            if(min == product2){
                product2 = 2 * ugly[p2];
                p2++;
            }
            if(min == product3){
                product3 = 3 * ugly[p3];
                p3++;
            }
            if(min == product5){
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        return ugly[n-1];
    }
}