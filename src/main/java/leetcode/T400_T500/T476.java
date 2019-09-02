package leetcode.T400_T500;

public class T476 {

    public int findComplement(int num) {
        int res = 0, mask = 1, shift = 0;
        while (num >= mask) {
            if ((num & mask) == 0) {
                res |= (1 << shift);
            }
            ++shift;
            mask <<= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        T476 solution = new T476();
        System.out.println(solution.findComplement(1));
    }

}
