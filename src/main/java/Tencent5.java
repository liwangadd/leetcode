import java.util.Scanner;

public class Tencent5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), l = scanner.nextInt();
        int colors[] = new int[n];
        for(int i=0;i<n;++i){
            colors[i] = scanner.nextInt();
        }
        int diffColor = 1;
        for(int i = 1;i<n;++i){
            if(colors[i]!=colors[i-1]) ++diffColor;
        }
    }

}
