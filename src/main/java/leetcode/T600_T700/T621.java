package leetcode.T600_T700;

public class T621 {

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0, maxCount = 0;
        for (char task : tasks) {
            ++counter[task - 'A'];
            if (counter[task - 'A'] == max) {
                ++maxCount;
            } else if (counter[task - 'A'] > max) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;
        int partLen = n - (maxCount - 1);
        int emptySlots = partCount * partLen;
        int availableTasks = tasks.length - max * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idles;
    }

    public static void main(String[] args) {
        new T621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

}
