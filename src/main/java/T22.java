import java.util.LinkedList;
import java.util.List;

public class T22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generateParenthesis("", n, n, res);
        return res;
    }

    public void generateParenthesis(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
        }
        if (left > 0) {
            generateParenthesis(str + "(", left - 1, right, res);
        }
        if (right > left) {
            generateParenthesis(str + ")", left, right - 1, res);
        }
    }

}
