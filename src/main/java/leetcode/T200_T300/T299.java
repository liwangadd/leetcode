package leetcode.T200_T300;

public class T299 {

    public String getHint(String secret, String guess) {
        int[] secretFlag = new int[10];
        int[] guessFlag = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) ++bulls;
            else {
                secretFlag[secret.charAt(i) - '0']++;
                guessFlag[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; ++i) {
            cows += Math.min(secretFlag[i], guessFlag[i]);
        }
        return String.valueOf(bulls) + 'A' + cows + 'B';
    }

}
