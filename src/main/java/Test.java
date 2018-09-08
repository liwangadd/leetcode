import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line;
        line = sc.nextLine();
        String[] points = line.split(",");
        int testX = Integer.valueOf(points[0]);
        int testY = Integer.valueOf(points[1]);
        List<Integer> verx = new ArrayList<Integer>();
        List<Integer> very = new ArrayList<Integer>();

        line = sc.nextLine();
        points = line.split(",");
        for (int i = 0; i < points.length; i += 2) {
            verx.add(Integer.valueOf(points[i]));
            very.add(Integer.valueOf(points[i + 1]));
        }
    }

    private static int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        Map<Integer, Integer>[] map = new Map[A.length];
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                if (Math.abs((long) A[i] - A[j]) > Integer.MAX_VALUE) {
                    continue;
                }
                int d = A[i] - A[j];
                int map_i_d = map[i].getOrDefault(d, 0);
                int map_j_d = map[j].getOrDefault(d, 0);
                map_i_d += map_j_d + 1;
                map[i].put(d, map_i_d);
                ans += map_j_d;
            }
        }
        return ans;
    }
}