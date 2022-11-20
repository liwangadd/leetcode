package leetcode;

public class T1678 {

    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char lastC = ' ';
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'G':
                    sb.append(c);
                    break;
                case ')':
                    if (lastC == '(') sb.append('o');
                    else sb.append("al");
                    break;
                default:
                    lastC = c;
            }
        }
        return sb.toString();
    }

}
