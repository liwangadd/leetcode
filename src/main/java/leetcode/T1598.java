package leetcode;

public class T1598 {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            switch (log) {
                case "../":
                    depth = Math.max(depth - 1, 0);
                    break;
                case "./":
                    break;
                default:
                    ++depth;
            }
        }
        return depth;
    }

}
