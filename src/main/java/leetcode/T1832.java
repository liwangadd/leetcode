package leetcode;

public class T1832 {

    public boolean checkIfPangram(String sentence) {
        boolean[] flags = new boolean[26];
        for (char c : sentence.toCharArray()) {
            flags[c - 'a'] = true;
        }
        for (boolean flag : flags) {
            if (!flag) return false;
        }
        return true;
    }

}
