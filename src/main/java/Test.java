import java.util.*;

public class Test {

    static class Node{
        int a, b, c;
        public Node(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Node> nodes = new ArrayList<>();
        for(int i=0;i<num;++i){
            int a=scanner.nextInt(), b = scanner.nextInt(), c=scanner.nextInt();
            Node node = new Node(a, b,c);
            nodes.add(node);
        }
        int count = 0;
        for(int i=0, len=nodes.size();i<len;++i){
            for(int j=0;j<len;++j){
                if(nodes.get(i).a>nodes.get(j).a&&nodes.get(i).b>nodes.get(j).b&&nodes.get(i).c>nodes.get(j).c){
                    ++count;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}