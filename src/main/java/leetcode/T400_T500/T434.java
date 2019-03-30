package leetcode.T400_T500;

public class T434 {

    public static int countSegments(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        String[] splits = s.split("\\s+");
        return splits.length;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("    foo    bar"));
    }

}
