package basic;

public class Search {

    /**
     * 顺序查找，数组可以无序
     *
     * @param arr   数组
     * @param value 待查找元素
     * @return true:存在 false:不能存在
     */
    public boolean SequenceSearch(int[] arr, int value) {
        for (int anArr : arr) {
            if (anArr == value) return true;
        }
        return false;
    }

    /**
     * 二分查找，数组必须有序
     *
     * @param arr   数组
     * @param value 待查找元素
     * @return true:存在 false:不能存在
     */
    public boolean binarySearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == value) return true;
            else if (mid > value) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

}
