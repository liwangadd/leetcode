package leetcode;

import com.google.common.collect.Sets;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class T2299 {

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean lowerCase = false, upperCase = false, digit = false, special = false;
        Set<Character> specialChars = new HashSet<>();
        for (char c : "!@#$%^&*()-+".toCharArray()) {
            specialChars.add(c);
        }
        char lastChar = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowerCase = true;
            } else if (Character.isUpperCase(c)) {
                upperCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (specialChars.contains(c)) {
                special = true;
            }
            if (c == lastChar) return false;
            lastChar = c;
        }
        return lowerCase && upperCase && digit && special;
    }

}
