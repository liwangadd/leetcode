package T200_T300;

public class T223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        if (E >= C || G <= A || D <= F || H <= B) return area1 + area2;

        int lbY = Math.max(B, F);
        int lbX = Math.max(A, E);
        int trX = Math.min(C, G);
        int trY = Math.min(D, H);
        int area3 = (trX - lbX) * (trY - lbY);

        return area1 + area2 - area3;
    }

    public static void main(String[] args) {
        T223 solution = new T223();
        System.out.println(solution.computeArea(-2, -2, 2, 2, 1, -3, 3, -1));
    }

}
