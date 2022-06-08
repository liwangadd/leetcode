package leetcode;

import com.sun.deploy.panel.ITreeNode;

import java.util.HashSet;
import java.util.Set;

public class T1461 {

    public boolean hasAllCodes(String s, int k) {
        int count = (int) Math.pow(2, k);
        if (s.length() - k + 1 < count) return false;
        Set<String> container = new HashSet<>();
        int right = 0;
        StringBuilder sb = new StringBuilder();
        for (; right < k; right++) {
            sb.append(s.charAt(right));
        }
        container.add(sb.toString());
        for (; right < s.length(); ++right) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(right));
            container.add(sb.toString());
            if (container.size() == count) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new T1461().hasAllCodes("000011010111011001001111111001000100100100010100101100001101101101110001100100101111100111001001111001001010111010010101101001001110011100110101001001001000000110101001010011101100110110100010000", 7);
        System.out.println(res);
    }

}
