package leetcode.T1000_T1100;

public class T1089 {

    public void duplicateZeros(int[] arr) {
        int[] coped = new int[arr.length];
        int index = 0;
        for (int num : arr) {
            if (index == arr.length) break;
            if (num == 0) coped[index++] = num;
            coped[index++] = num;
        }
        System.arraycopy(coped, 0, arr, 0, coped.length);
    }

}
