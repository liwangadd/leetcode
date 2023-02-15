package leetcode;

public class T1523 {

    public int countOdds(int low, int high) {
        if ((low & 1) == 1) return (high - low) / 2 + 1;
        else {
            if (((high - low) & 1) == 1) return (high - low) / 2 + 1;
            else return (high - low) / 2;
        }
    }

}
