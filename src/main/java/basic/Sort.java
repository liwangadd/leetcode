package basic;

public class Sort {

    /**
     * 冒泡排序
     * <p>
     * 比较相邻的元素，如果第一个比第二个大，就交换他们。
     * 对每一对相邻元素作同样的工作，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param numbers 待排序的整型数组
     */
    public void bubbleSort(int[] numbers) {
        int len = numbers.length;
        boolean isSwap = false;
        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - 1 - i; ++j) {
                if (numbers[j] > numbers[j + 1]) {
                    isSwap = true;
                    swap(numbers, j, j + 1);
                }
            }
            if (!isSwap) break;
            else isSwap = false;
        }
    }

    /**
     * 插入排序
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素大于新元素，降该元素移到下一位置，重复该步骤，直到找到已排序的元素小于或者等于新元素的位置，将新元素插入该位置
     *
     * @param numbers 待排序的整型数组
     */
    public void insertSort(int[] numbers) {
        int len = numbers.length;
        int tmp;
        for (int i = 1; i < len; ++i) {
            tmp = numbers[i];
            int j = i;
            for (; j > 0 && numbers[j - 1] > tmp; --j) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = tmp;
        }
    }

    /**
     * 选择排序
     * <p>
     * 在未排序序列中找到最小元素，放到排序序列末尾
     * 以此类推，知道所有元素排序完毕
     *
     * @param numbers 待排序的整型数组
     */
    public void selectSort(int[] numbers) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < len; ++j) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            swap(numbers, i, minIndex);
        }
    }

    /**
     * 希尔排序
     * <p>
     * 将待排序数组元素，按下标的一定增量分组
     * 分成多个子序列，然后对各个子序列进行直接插入排序
     * 然后依次缩减增量再进行排序，知道增量为1时，进行最后一个直接插入排序
     *
     * @param numbers 待排序的整型数组
     */
    public void shellSort(int[] numbers) {
        for (int increment = numbers.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < numbers.length; ++i) {
                int tmp = numbers[i];
                int j = i;
                for (; j >= increment; j -= increment) {
                    if (tmp < numbers[j - increment]) {
                        numbers[j] = numbers[j - increment];
                    } else {
                        break;
                    }
                }
                numbers[j] = tmp;
            }
        }
    }

    /**
     * 归并排序
     * <p>
     * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
     * 即把待排序序列分为若干个子序列，每个子序列是有序的。
     * 然后再把有序子序列合并为整体有序序列。
     *
     * @param numbers 待排序的整型数组
     */
    public void mergeSort(int[] numbers) {
        mergeSort_sort(numbers, 0, numbers.length - 1);
    }

    private void mergeSort_sort(int[] numbers, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort_sort(numbers, left, mid);
            mergeSort_sort(numbers, mid + 1, right);
            mergeSort_merge(numbers, left, mid, right);
        }
    }

    private void mergeSort_merge(int[] numbers, int left, int mid, int right) {
        int[] arr = new int[right - mid];
        System.arraycopy(numbers, mid + 1, arr, 0, arr.length);
        int leftEnd = mid, rightEnd = arr.length - 1;
        for (int i = right; i >= left; --i) {
            if (rightEnd >= 0 && leftEnd >= left)
                if (arr[rightEnd] > numbers[leftEnd]) {
                    numbers[i] = arr[rightEnd--];
                } else {
                    numbers[i] = numbers[leftEnd--];
                }
            else if (rightEnd >= 0) numbers[i] = arr[rightEnd--];
            else numbers[i] = numbers[leftEnd--];
        }
    }

    /**
     * 堆排序
     * <p>
     * 初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个 堆，这时堆的根节点的数最大.
     * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆.
     * 依此类推，直到只有两个节点的堆，并对 它们作交换，最后得到有n个节点的有序序列.
     *
     * @param numbers 待排序的整型数组
     */
    public void heapSort(int[] numbers) {
        for (int i = numbers.length / 2; i >= 0; i--) {
            heapAdjust(numbers, i, numbers.length);
        }
        for (int i = numbers.length - 1; i > 0; i--) {
            swap(numbers, 0, i);
            heapAdjust(numbers, 0, i);
        }
    }

    private void heapAdjust(int[] numbers, int i, int n) {
        int child;
        int father;
        for (father = numbers[i]; 2 * i + 1 < n; i = child) {
            child = 2 * i + 1;
            if (child != n - 1 && numbers[child] < numbers[child + 1]) {
                child++;
            }
            if (father < numbers[child]) {
                numbers[i] = numbers[child];
            } else {
                break;
            }
        }
        numbers[i] = father;
    }

    /**
     * 快速排序
     *
     * @param numbers 待排序的整型数组
     */
    public void quickSort(int[] numbers) {
        qSort(numbers, 0, numbers.length - 1);
    }

    private void qSort(int[] numbers, int low, int high) {
        int left = low, right = high;
        if (low < high) {
            int pivot = numbers[low];
            while (low < high) {
                while (low < high && numbers[high] >= pivot) --high;
                numbers[low] = numbers[high];
                while (low < high && numbers[low] <= pivot) ++low;
                numbers[high] = numbers[low];
            }
            numbers[low] = pivot;
            qSort(numbers, left, low - 1);
            qSort(numbers, low + 1, right);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] numbers = new int[]{3, 6, 1, 7, 3, 5, 2};
        sort.quickSort(numbers);
        for (int number : numbers) {
        System.out.print(number + " ");
    }
        System.out.println();
    }

}
