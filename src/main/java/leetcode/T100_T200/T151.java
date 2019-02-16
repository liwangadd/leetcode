package leetcode.T100_T200;

public class T151 {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; --i) {
            sb.append(words[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T151().reverseWords("   the   sky is   blue   "));
    }

}
