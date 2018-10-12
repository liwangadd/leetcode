package T1_T100;

import java.util.Stack;

public class T71 {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            if ("..".equals(dir)) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (".".equals(dir)) {
                continue;
            } else {
                if (!"".equals(dir)) {
                    stack.push(dir);
                }
            }
        }
        StringBuilder r = new StringBuilder();
        for (String dir : stack) {
            r.append("/").append(dir);
        }
        return "".equals(r.toString()) ? "/" : r.toString();
    }

    public static void main(String[] args) {
//        System.out.println(simplifyPath("///"));
//        System.out.println(simplifyPath("/home"));
//        System.out.println(simplifyPath("/a/./b/../../c/"));
//        System.out.println(simplifyPath("/a/../../b/../c//.//"));
//        System.out.println(simplifyPath("/a//b////c/d//././/.."));
        System.out.println(simplifyPath("/..."));
    }

}
