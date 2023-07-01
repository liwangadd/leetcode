package leetcode.T700_T800;

public class T744 {

    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] flags = new boolean[26];
        for (char letter : letters) flags[letter - 'a'] = true;
        for (char c = (char) (target + 1); c <= 'z'; ++c) if (flags[c - 'a']) return c;
        return letters[0];
    }

}
