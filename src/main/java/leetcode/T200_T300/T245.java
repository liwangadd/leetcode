package leetcode.T200_T300;

public class T245 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (pos2 != -1) {
                    min = Math.min(min, i - pos2);
                }
                pos1 = i;
            }
            if (words[i].equals(word2)) {
                if (pos1 != -1 && !word1.equals(word2)) {
                    min = Math.min(min, i - pos2);
                }
                pos2 = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        T245 solution = new T245();
        System.out.println(solution.shortestWordDistance(words, "makes", "coding"));
        System.out.println(solution.shortestWordDistance(words, "makes", "makes"));
    }
}
