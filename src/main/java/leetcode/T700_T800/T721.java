package leetcode.T700_T800;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class T721 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                owners.put(account.get(i), account.get(0));
                parents.put(account.get(i), account.get(i));
            }
        }
        for (List<String> account : accounts) {
            String root = find(account.get(1), parents);
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i), parents), root);
            }
        }
        for (List<String> account : accounts) {
            String root = find(account.get(1), parents);
            for (int i = 1; i < account.size(); i++) {
                if (!unions.containsKey(root)) unions.put(root, new TreeSet<>());
                unions.get(root).add(account.get(i));
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<String, TreeSet<String>> entry : unions.entrySet()) {
            List<String> items = new LinkedList<>(entry.getValue());
            items.add(0, owners.get(entry.getKey()));
            res.add(items);
        }
        return res;
    }

    private String find(String account, Map<String, String> parents) {
        return parents.get(account).equals(account) ? account : find(parents.get(account), parents);
    }

}
