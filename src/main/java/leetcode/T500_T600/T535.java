package leetcode.T500_T600;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class T535 {

    private char[] chars;
    private Map<String, String> map;
    private Random random;

    public T535() {
        chars = new char[62];
        int index = 0;
        for (int i = 'a'; i <= 'z'; ++i) {
            chars[index++] = (char) i;
        }
        for (int i = 'A'; i <= 'Z'; ++i) {
            chars[index++] = (char) i;
        }
        for (int i = '0'; i <= '9'; ++i) {
            chars[index++] = (char) i;
        }
        map = new HashMap<>();
        random = new Random();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] res = new char[6];
        do {
            for (int i = 0; i < 6; ++i) {
                res[i] = chars[random.nextInt(chars.length)];
            }
        } while (map.containsKey(new String(res)));
        String shortUrl = new String(res);
        map.put(longUrl, shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
