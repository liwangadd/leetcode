package leetcode.T200_T300;

public class T264 {

    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int count = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        int num1 = arr[0] * 2, num2 = arr[0] * 3, num3 = arr[0] * 5;
        while (count < n) {
            if (num1 < num2) {
                if (num1 < num3) {
                    arr[count++] = num1;
                    num1 = arr[++index1] * 2;
                } else if (num1 > num3) {
                    arr[count++] = num3;
                    num3 = arr[++index3] * 5;
                } else {
                    arr[count++] = num1;
                    num1 = arr[++index1] * 2;
                    num3 = arr[++index3] * 5;
                }
            } else if (num1 > num2) {
                if (num2 < num3) {
                    arr[count++] = num2;
                    num2 = arr[++index2] * 3;
                } else if (num2 > num3) {
                    arr[count++] = num3;
                    num3 = arr[++index3] * 5;
                } else {
                    arr[count++] = num2;
                    num2 = arr[++index2] * 3;
                    num3 = arr[++index3] * 5;
                }
            } else {
                if (num1 < num3) {
                    arr[count++] = num1;
                    num1 = arr[++index1] * 2;
                    num2 = arr[++index2] * 3;
                } else if (num1 > num3) {
                    arr[count++] = num3;
                    num3 = arr[++index3] * 5;
                } else {
                    arr[count++] = num1;
                    num1 = arr[++index1] * 2;
                    num3 = arr[++index3] * 5;
                    num2 = arr[++index2] * 3;
                }
            }
        }
        return arr[n - 1];
    }

    public int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }

    public static void main(String[] args) {
        T264 solution = new T264();
        System.out.println(solution.nthUglyNumber(1690));
        System.out.println(solution.nthUglyNumber2(1690));
    }

}
