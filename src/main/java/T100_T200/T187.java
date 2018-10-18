package T100_T200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T187 {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ones = new HashSet<>();
        Set<String> twos = new HashSet<>();
        for(int i=0;i<s.length()-9;++i){
            String subStr = s.substring(i, i+10);
            if(!ones.add(subStr)){
                twos.add(subStr);
            }
        }
        return new ArrayList<>(twos);
    }

}
