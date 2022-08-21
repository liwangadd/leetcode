package leetcode.T700_T800;

import java.util.LinkedList;
import java.util.List;

public class T722 {

    public List<String> removeComments(String[] lines) {
        boolean blockComment = false;
        StringBuilder lineBuilder = new StringBuilder();
        List<String> target = new LinkedList<>();
        for (String line : lines) {
            for (int i = 0, len = line.length(); i < len; ++i) {
                char c = line.charAt(i);
                if (blockComment && c == '*' && i < len - 1 && line.charAt(i + 1) == '/') {
                    blockComment = false;
                    ++i;
                } else if (!blockComment && c == '/' && i < len - 1) {
                    if (line.charAt(i + 1) == '/') break;
                    else if (line.charAt(i + 1) == '*') {
                        blockComment = true;
                        ++i;
                    } else {
                        lineBuilder.append(c);
                    }
                } else if (!blockComment) {
                    lineBuilder.append(c);
                }
            }
            if (!blockComment && lineBuilder.length() > 0) {
                target.add(lineBuilder.toString());
                lineBuilder.setLength(0);
            }
        }
        if (lineBuilder.length() > 0) target.add(lineBuilder.toString());
        return target;
    }

}
