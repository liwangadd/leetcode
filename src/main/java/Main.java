import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public int calculate(String s) {
        Deque<Integer> numbers = new LinkedList<>();
        Deque<Integer> counts = new LinkedList<>();
        numbers.addLast(0);
        int curCount = 1, curNumber = 0, isPositive = 1;
        char[] sArr = s.toCharArray();
        for (int i = 0, len = s.length(); i < len; ++i) {
            switch (sArr[i]) {
                case '+':
                    numbers.addLast(curNumber * isPositive);
                    curNumber = 0;
                    ++curCount;
                    isPositive = 1;
                    break;
                case '-':
                    numbers.addLast(curNumber * isPositive);
                    curNumber = 0;
                    ++curCount;
                    isPositive = -1;
                    break;
                case '(':
                    counts.addLast(curCount * isPositive);
                    numbers.add(0);
                    curCount = 1;
                    isPositive = 1;
                    break;
                case ')':
                    curNumber *= isPositive;
                    while (curCount-- > 0)
                        curNumber += numbers.pollLast();
                    Integer prevCount = counts.pollLast();
                    isPositive = prevCount < 0 ? -1 : 1;
                    curCount = Math.abs(prevCount);
                    break;
                case ' ':
                    break;
                default:
                    curNumber = curNumber * 10 + (sArr[i] - '0');
            }
        }
        curNumber *= isPositive;
        while (!numbers.isEmpty())
            curNumber += numbers.pollLast();
        return curNumber;
    }

    public static void main(String[] args) {
        System.out.println(new Main().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}

