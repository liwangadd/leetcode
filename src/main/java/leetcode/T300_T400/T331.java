package leetcode.T300_T400;

public class T331 {

    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) return false;
        String[] splits = preorder.split(",");
        int count = 0;
        for (String split : splits) {
            if (!split.equals("#")) {
                if (count < 0) return false;
                else ++count;
            } else {
                --count;
            }
        }
        return count == -1;
    }

}
