package leetcode.T100_T200;

public class T186 {

    public char[] reverseWords(char[] str) {
        // write your code here
        int left = 0, right = str.length - 1;
        while(left < right){
            swap(str, left++, right--);
        }
        left = 0;
        for(int i = 0; i < str.length; ++i){
            if(i == str.length - 1 || str[i + 1] == ' '){
                right = i;
                while(left < right){
                    swap(str, left++, right--);
                }
                left = i + 2;
            }
        }
        return str;
    }

    private void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

}
