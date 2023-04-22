package leetcode.T900_T1000;

public class T946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int stackIndex = 0, popIndex = 0;
        for (int ele : pushed) {
            stack[stackIndex++] = ele;
            while (stackIndex > 0 && stack[stackIndex - 1] == popped[popIndex]) {
                --stackIndex;
                ++popIndex;
            }
        }
        return stackIndex == 0;
    }

}
