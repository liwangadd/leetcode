package leetcode;

public class T1323 {

    public int maximum69Number(int num) {
        char[] numStr = String.valueOf(num).toCharArray();
        for (int i = 0; i < numStr.length; ++i) {
            if (numStr[i] == '6') {
                numStr[i] = '9';
                return Integer.parseInt(new String(numStr));
            }
        }
        return num;
    }

}
