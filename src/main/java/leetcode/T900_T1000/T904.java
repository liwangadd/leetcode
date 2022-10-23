package leetcode.T900_T1000;

import java.util.HashSet;
import java.util.Set;

public class T904 {

    public int totalFruit(int[] fruits) {
        int prev = fruits[0] - 1, fruit1 = -1, fruit2 = -1, total = 0;
        for (int index = 0, len = fruits.length, step = 0; index + step < len; ++index) {
            while (fruits[index] == prev) ++index;
            for (step = 0; index + step < len; ++step) {
                int fruit = fruits[index + step];
                if (fruit1 == -1) fruit1 = fruit;
                else if (fruit2 == -1 && fruit != fruit1) fruit2 = fruit;
                else if (fruit1 != fruit && fruit2 != fruit) {
                    total = Math.max(total, step);
                    break;
                }
                if (index + step == len - 1) {
                    total = Math.max(total, step + 1);
                    break;
                }
            }
            prev = fruits[index];
            fruit1 = fruit2 = -1;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new T904().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

}
