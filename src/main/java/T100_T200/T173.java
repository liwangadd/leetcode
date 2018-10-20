package T100_T200;

import utils.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class T173 {

    private List<Integer> searchList;
    private Iterator<Integer> iterator;

    public T173(TreeNode root) {
        this.searchList = new LinkedList<>();
        tree2List(root);
        this.iterator = searchList.iterator();
    }

    private void tree2List(TreeNode root) {
        if (root == null) return;
        tree2List(root.left);
        searchList.add(root.val);
        tree2List(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }

}
