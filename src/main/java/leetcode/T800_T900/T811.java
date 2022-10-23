package leetcode.T800_T900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] cpDomain = cpdomain.split(" ");
            String[] subDomains = cpDomain[1].split("\\.");
            int count = Integer.parseInt(cpDomain[0]);
            String domain = subDomains[subDomains.length - 1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (int i = subDomains.length - 2; i >= 0; --i) {
                domain = subDomains[i] + "." + domain;
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

}
