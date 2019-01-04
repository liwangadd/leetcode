package leetcode.T300_T400;

import leetcode.T1_T100.T38;

import java.util.*;

public class T380 {

    private List<Integer> data;
    private Map<Integer, Integer> index;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public T380() {
        data = new ArrayList<>(1000);
        index = new HashMap<>();
        random=new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        } else {
            data.add(val);
            index.put(val, data.size() - 1);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if(!index.containsKey(val)){
            return false;
        }else{
            int pos = index.get(val);
            data.set(pos, data.get(data.size()-1));
            index.put(data.get(pos), pos);
            data.remove(data.size()-1);
            index.remove(val);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int pos = random.nextInt(data.size());
        return data.get(pos);
    }

    public static void main(String[] args) {
        T380 solution = new T380();
        solution.remove(0);
        solution.remove(0);
        solution.insert(0);
        solution.getRandom();
        solution.remove(0);
        solution.insert(0);
    }

}
