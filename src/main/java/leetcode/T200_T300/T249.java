package leetcode.T200_T300;

import java.util.*;

public class T249 {

    public List<List<String>> groupStrings(List<String> strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            StringBuilder sb = new StringBuilder("0");
            for (int i = 1; i < str.length(); ++i) {
                int val = str.charAt(i) - str.charAt(i - 1);
                val = val < 0 ? val + 26 : val;
                sb.append(val);
            }
            if(map.containsKey(sb.toString())){
                List<String> item = map.get(sb.toString());
                item.add(str);
            }else{
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(sb.toString(), item);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        T249 solution=new T249();
        List<String> strings = new ArrayList<>(Arrays.asList("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"));
        for (List<String> stringList : solution.groupStrings(strings)) {
            for (String s : stringList) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
