package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class T1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int circularNum = 0, squareNum = 0, totalNum = students.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            if (student == 0) ++circularNum;
            else ++squareNum;
            queue.add(student);
        }
        int i = 0, len = sandwiches.length;
        while (i < len) {
            if (circularNum == 0 && sandwiches[i] == 0 || squareNum == 0 && sandwiches[i] == 1) {
                return totalNum;
            }
            int student = queue.poll();
            if (student == sandwiches[i]) {
                ++i;
                --totalNum;
                if (student == 0) --circularNum;
                else --squareNum;
            } else queue.add(student);
        }
        return 0;
    }

}
