package leetcode.T200_T300;

import java.util.ArrayList;
import java.util.List;

public class T267 {

    private List<String> res;
    private char oddChar = 0;

    public List<String> generatePalindromes(String s) {
        char[] sArr = s.toCharArray();
        int[] charCount = new int[26];
        oddChar = 0;
        for (char aSArr : sArr) charCount[aSArr - 'a']++;
        int counts = 0;
        for (int i = 0; i < 26; ++i) {
            if ((charCount[i] & 1) == 1) {
                if (oddChar != 0) return new ArrayList<>();
                else oddChar = (char) (i + 'a');
            }
            charCount[i] = charCount[i] / 2;
            counts += charCount[i];
        }

        char[] sList = new char[counts];
        boolean[] used = new boolean[counts];
        int index = 0;
        for (int i = 0; i < 26; ++i) {
            while (charCount[i]-- != 0) sList[index++] = (char) (i + 'a');
        }
        res = new ArrayList<>();
        generatePalindromes(sList, used, new StringBuilder());
        return res;
    }

    private void generatePalindromes(char[] sList, boolean[] used, StringBuilder sb) {
        if (sb.length() == sList.length) {
            StringBuilder item = new StringBuilder(sb);
            if (oddChar != 0) item.append(oddChar);
            item.append(sb.reverse());
            res.add(item.toString());
            sb.reverse();
            return;
        }
        int index = 0;
        while (index < sList.length) {
            if (!used[index]) {
                sb.append(sList[index]);
                used[index] = true;
                generatePalindromes(sList, used, sb);
                sb.deleteCharAt(sb.length() - 1);
                used[index] = false;
                while (index < sList.length - 1 && sList[index + 1] == sList[index]) ++index;
            }
            ++index;
        }
    }

    public static void main(String[] args) {
        T267 solution = new T267();
        for (String str : solution.generatePalindromes("aabbccddd")) {
            System.out.println(str);
        }
    }

}
