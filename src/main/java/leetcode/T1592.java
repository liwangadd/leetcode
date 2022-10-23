package leetcode;

public class T1592 {

    public String reorderSpaces(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') ++spaceCount;
        }
        String[] parts = text.trim().split("\\s+");
        int avgSpaces = 0;
        if (parts.length > 1) {
            avgSpaces = spaceCount / (parts.length - 1);
        }
        int tailSpaces = spaceCount - (avgSpaces * (parts.length - 1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1) {
                for (int i1 = 0; i1 < avgSpaces; i1++) {
                    sb.append(' ');
                }
            }
        }
        while (tailSpaces-- > 0) sb.append(' ');
        return sb.toString();
    }

    public static void main(String[] args) {
        new T1592().reorderSpaces("  this   is  a sentence ");
    }

}
