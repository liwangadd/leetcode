package sword;

public class DuplicationInArray {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) return false;
        for (int number : numbers) {
            if (number < 0 || number > length - 1) return false;
        }
        for (int i = 0; i < length; ++i) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    public void swap(int numbers[], int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

}
