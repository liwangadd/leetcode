package leetcode.T1_T100;

public class T58 {

    private static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s=s.trim();
        int lastIndex = s.lastIndexOf(" ");
        return s.length() - lastIndex - 1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("World"));
    }

}
