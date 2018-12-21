package leetcode.T1_T100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if(strs==null||strs.length==0) return res;

        Map<Map<Character, Integer>, List<String>> map=new HashMap<>();

        for (String str : strs) {
            Map<Character,Integer> mapItem = new HashMap<>();
            for(int i=0;i<str.length();++i){
                char c = str.charAt(i);
                mapItem.put(c, mapItem.getOrDefault(c, 0) + 1);
            }
            if(map.containsKey(mapItem)){
                List<String> strList = map.get(mapItem);
                strList.add(str);
                map.put(mapItem, strList);
            }else{
                List<String> strList = new LinkedList<>();
                strList.add(str);
                map.put(mapItem, strList);
            }
        }

        res.addAll(map.values());

        return res;
    }

}
