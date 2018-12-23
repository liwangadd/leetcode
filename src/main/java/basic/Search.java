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
            if (arr[mid] == value) return true;
            else if (arr[mid] > value) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    /**
     * 插值查找，数组必须有序
     * 二分查找的升级版，在选择切分点时具有自适应性
     *
     * @param arr   数组
     * @param value 待查找元素
     * @return true:存在 false:不能存在
     */
    public boolean insertSearch(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (value - arr[left]) / (arr[right] - arr[left]) * (right - left);
            if (arr[mid] == value) return true;
            else if (arr[mid] > value) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

}
