package leetcode;

public class T1758 {

    public int minOperations(String s, char start) {
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c != start) {
                answer += 1;
            }
            if (start == '0') {
                start = '1';
            } else {
                start = '0';
            }
        }
        return answer;
    }

    public int minOperations(String s) {
        return Math.min(this.minOperations(s, '0'), this.minOperations(s, '1'));
    }

}
