package leetcode;

public class T1163 {

    public String lastSubstring(String s) {
        int slow = 0, fast = 1, end = s.length();
        while (fast < end) {
            int step = 0;
            while (fast + step < end && s.charAt(slow + step) == s.charAt(fast + step)) ++step;
            if (fast + step < end && s.charAt(slow + step) < s.charAt(fast + step)) {
                int holder = slow;
                slow = fast;
                fast = Math.max(fast + 1, holder + step + 1);
            } else {
                fast = fast + step + 1;
            }
        }
        return s.substring(slow);
    }

}
