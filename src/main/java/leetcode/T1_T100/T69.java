package leetcode.T1_T100;

public class T69 {

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public int mySqrt2(int x) {
        int left = 0, right = x;
        while (left < right) {
            if(right - left == 1){
                return right;
            }
            int mid = left + (right - left) / 2;
            if (x / mid >= mid && x / (mid + 1) < mid + 1) {
                return mid;
            }else if(x / mid > mid){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T69 solution = new T69();
        System.out.println(solution.mySqrt2(32980));
        System.out.println(solution.mySqrt(32980));
    }
}
