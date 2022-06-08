package leetcode;

import java.nio.file.spi.FileSystemProvider;

public class T1342 {

    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if ((num & 1) == 0) num /= 2;
            else num -= 1;
        }
        return step;
    }

}
