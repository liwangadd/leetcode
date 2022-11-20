package leetcode;

public class T1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String str : word1){
            sb1.append(str);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str : word2){
            sb2.append(str);
        }

        String w1 = sb1.toString();
        String w2 = sb2.toString();

        return w1.equals(w2);
    }

}
