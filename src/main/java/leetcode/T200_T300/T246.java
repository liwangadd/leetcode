package leetcode.T200_T300;

import java.util.HashMap;
import java.util.Map;

public class T246 {

    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int mid = (num.length() + 1) / 2;
        for (int i = 0; i < mid; i++) {
            if(!map.containsKey(num.charAt(num.length()-1-i))) return false;
            if (num.charAt(i) != map.get(num.charAt(num.length() - 1 - i))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        T246 solution = new T246();
        System.out.println(solution.isStrobogrammatic("7"));
    }

}
