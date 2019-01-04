package sword;

public class ReplaceSpaces {

    public String replaceSpace(String str) {
        if (str == null || str.length() == 0) return str;
        int length = str.length();
        int spaceCount = 0;
        for (int i = 0; i < length; ++i) {
            if (str.charAt(i) == ' ') ++spaceCount;
        }
        int newLength = str.length() + 2 * spaceCount;
        char[] res = new char[newLength];
        int p1 = length - 1, p2 = newLength - 1;
        while (p1 >= 0) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                res[p2--] = '%';
                res[p2--] = '2';
                res[p2--] = '0';
            } else {
                res[p2--] = c;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        ReplaceSpaces solution = new ReplaceSpaces();
        System.out.println(solution.replaceSpace("We Are Happy"));
    }
}
