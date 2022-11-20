package leetcode;

public class T1668 {

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String seqPart = word;
        while (sequence.contains(seqPart)) {
            ++count;
            seqPart = seqPart + word;
        }
        return count;
    }

}
