package leetcode.T200_T300;

public class T243 {

    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -1, pos2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) {
                if (pos2 != -1) {
                    min = Math.min(min, i - pos2);
                }
                pos1 = i;
            } else if (words[i].equals(word2)) {
                if (pos1 != -1) {
                    min = Math.min(min, i - pos1);
                }
                pos2 = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        T243 solution = new T243();
        System.out.println(solution.shortestDistance(words, "coding", "practice"));
        System.out.println(solution.shortestDistance(words, "makes", "coding"));
    }
}
