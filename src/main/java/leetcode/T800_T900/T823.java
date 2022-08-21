package leetcode.T800_T900;

import com.sun.deploy.security.MacOSXDeployNTLMAuthCallback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class T823 {

    private static final long MOD = (long) (1e9 + 7);

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Long> container = new HashMap<>();
        Arrays.sort(arr);
        long ans = 0;
        for (int num : arr) {
            long count = 1;
            for (Map.Entry<Integer, Long> entry : container.entrySet()) {
                int key = entry.getKey();
                if (num % key == 0) {
                    int divided = num / key;
                    if (!container.containsKey(divided)) continue;
                    long multi1 = entry.getValue(), multi2 = container.get(divided);
                    count = (count + multi1 * multi2) % MOD;
                }
            }
            container.put(num, count);
            ans = (ans + count) % MOD;
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new T823().numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
    }

}
