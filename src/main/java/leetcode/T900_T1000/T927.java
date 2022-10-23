package leetcode.T900_T1000;

public class T927 {

    public int[] threeEqualParts(int[] arr) {
        int oneCount = 0;
        for (int num : arr) {
            if (num == 1) ++oneCount;
        }
        if (oneCount == 0) return new int[]{0, 2};
        if (oneCount % 3 != 0) return new int[]{-1, -1};
        int thirdStartIndex = arr.length - 1, avgOneCount = 0;
        for (; thirdStartIndex >= 0; --thirdStartIndex) {
            if (arr[thirdStartIndex] == 1) {
                if (++avgOneCount == oneCount / 3)
                    break;
            }
        }
        int res1 = findEndIdx(arr, 0, thirdStartIndex);
        if (res1 < 0) return new int[]{-1, -1};

        int res2 = findEndIdx(arr, res1 + 1, thirdStartIndex);
        if (res2 < 0) return new int[]{-1, -1};

        return new int[]{res1, res2 + 1};
    }

    private int findEndIdx(int[] A, int left, int right){
        while (A[left]==0) left++;
        while (right < A.length){
            if (A[left]!=A[right]) return -1;
            left++;
            right++;
        }
        return left-1;
    }

}
