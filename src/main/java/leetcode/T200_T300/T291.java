package leetcode.T200_T300;

import java.util.HashMap;
import java.util.Map;

public class T291 {

    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if(pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        Map<Character, String> patternToStr = new HashMap<>();
        Map<String, Character> strToPattern = new HashMap<>();
        return wordPatternMatch(pattern, str, patternToStr, strToPattern, 0, 0);
    }

    private boolean wordPatternMatch(String pattern, String str, Map<Character, String> patternToStr, Map<String, Character> strToPattern, int posPattern, int posString) {
        if(posPattern == pattern.length()) {
            return true;
        }
        if(str.length() == 0 && posPattern < pattern.length()) {
            return false;
        }

        int i = 0;
        for(i = posString; i < str.length(); i++) {
            String word = str.substring(posString, i + 1);
            if(posPattern >= pattern.length()) {
                return false;
            }
            char c = pattern.charAt(posPattern);

            if(!patternToStr.containsKey(c) && !strToPattern.containsKey(word)) {
                patternToStr.put(c, word);
                strToPattern.put(word, c);
                if(wordPatternMatch(pattern, str.substring(i + 1), patternToStr, strToPattern, posPattern + 1, 0)) {
                    return true;
                }
                patternToStr.remove(c);
                strToPattern.remove(word);
            } else if(patternToStr.containsKey(c) && !word.equals(patternToStr.get(c))) {
                if(word.length() == patternToStr.get(c).length()) {
                    return false;
                }
            } else if(strToPattern.containsKey(word) && c != strToPattern.get(word)) {
            } else {
                posPattern++;
                posString += word.length();
            }
        }

        return posPattern == pattern.length();
    }

}
