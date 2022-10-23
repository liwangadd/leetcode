package leetcode;

public class T1328 {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        char[] arr = palindrome.toCharArray();
        boolean replaced = false;
        for (int i = 0, len = arr.length / 2; i < len; ++i) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                replaced = true;
                break;
            }
        }
        if (!replaced) {
            arr[arr.length - 1] = 'b';
        }
        return new String(arr);
    }

}
