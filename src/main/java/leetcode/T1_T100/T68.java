package leetcode.T1_T100;

import java.util.LinkedList;
import java.util.List;

public class T68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + words[last].length() + 1 > maxWidth) break;
                count += words[last].length() + 1;
                ++last;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;
            if (diff == 0 || last == words.length) {
                for (int i = index; i < last; ++i) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length(); i < maxWidth; ++i) sb.append(" ");
            } else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());

            index = last;
        }
        return res;
    }

}
