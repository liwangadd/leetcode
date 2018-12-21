package leetcode.T300_T400;

public class T307 {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    private SegmentTreeNode root;

    public T307(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
            return node;
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public void update(int i, int val) {
        update(i, val, root);
    }

    private void update(int pos, int val, SegmentTreeNode node) {
        if (node.start == node.end) node.sum = val;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if (pos <= mid) update(pos, val, node.left);
            else update(pos, val, node.right);
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) return root.sum;
        int mid = root.start + (root.end - root.start) / 2;
        if (start >= mid + 1) return sumRange(root.right, start, end);
        else if (end <= mid) return sumRange(root.left, start, end);
        else return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    }

}
