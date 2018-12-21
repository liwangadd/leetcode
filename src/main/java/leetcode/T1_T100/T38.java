package leetcode.T1_T100;

public class T38 {

    public static String countAndSay(int n) {
        StringBuilder last;
        StringBuilder current = new StringBuilder("1");
        for (int i = 1; i < n; ++i) {
            last = current;
            current = new StringBuilder();
            char lastChar = last.charAt(0);
            int count = 1;
            for (int j = 1; j < last.length(); ++j) {
                if (last.charAt(j) == lastChar) ++count;
                else {
                    current.append(count).append(lastChar);
                    count = 0;
                    lastChar = last.charAt(j);
                    count++;
                }
            }
            current.append(count).append(lastChar);
        }
        return current.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }

}
