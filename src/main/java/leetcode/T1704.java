package leetcode;

public class T1704 {

    public boolean halvesAreAlike(String s) {
        int midLen = s.length() / 2;
        int count = 0;
        for (int i = 0; i < midLen; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                ++count;
        }
        for (int i = midLen; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                --count;
        }
        return count == 0;
    }

}
