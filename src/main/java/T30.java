import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        Map<String, Integer> freqMapRoot = new HashMap<>();
        if (words.length == 0) return res;
        int wordLength = words[0].length();
        int subLength = words.length * wordLength;
        if (s == null || s.length() == 0 || s.length() < subLength) return res;
        for (String word : words) {
            if (freqMapRoot.containsKey(word)) {
                freqMapRoot.put(word, freqMapRoot.get(word) + 1);
            } else {
                freqMapRoot.put(word, 1);
            }
        }

        for (int i = 0; i < s.length() - subLength; ++i) {
            Map<String, Integer> freqMap = new HashMap<>(freqMapRoot);
            String subStr = s.substring(i, i + subLength);
            int j = 0, count = 0;
            while (j < subStr.length()) {
                String word = subStr.substring(j, wordLength + j);
                if (freqMap.containsKey(word)) {
                    int freq = freqMap.get(word);
                    --freq;
                    ++count;
                    if (freq == 0) freqMap.remove(word);
                    else freqMap.put(word, freq);
                    j += wordLength;
                    if (count == words.length) res.add(i);
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (Integer pos : findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})) {
            System.out.print(pos);
        }
    }

}
