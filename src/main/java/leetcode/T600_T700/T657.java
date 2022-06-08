package leetcode.T600_T700;

public class T657 {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') --x;
            else if (c == 'R') ++x;
            else if (c == 'U') ++y;
            else if (c == 'D') --y;
        }
        return x == 0 && y == 0;
    }

}
