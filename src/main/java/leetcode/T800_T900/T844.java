package leetcode.T800_T900;

public class T844 {

    public boolean backspaceCompare(String s, String t) {
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder tBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && sBuilder.length() > 0) {
                sBuilder.deleteCharAt(sBuilder.length() - 1);
            } else if (s.charAt(i) != '#') {
                sBuilder.append(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && tBuilder.length() > 0) {
                tBuilder.deleteCharAt(tBuilder.length() - 1);
            } else if (t.charAt(i) != '#') {
                tBuilder.append(t.charAt(i));
            }
        }
        return sBuilder.toString().equals(tBuilder.toString());
    }

}
