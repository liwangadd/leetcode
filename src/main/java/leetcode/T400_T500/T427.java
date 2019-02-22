package leetcode.T400_T500;

import com.sun.org.apache.bcel.internal.generic.IFLE;

import javax.sound.midi.MidiChannel;

public class T427 {

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return build(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node build(int[][] grid, int top, int bottom, int left, int right) {
        if (top > bottom || left > right) return null;
        boolean isLeaf = true;
        int val = grid[top][left];
        for (int i = top; i <= bottom; ++i) {
            for (int j = left; j <= right; ++j) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) break;
        }
        if (isLeaf) return new Node(val==1, true, null, null, null, null);
        int rowMid = (top + bottom) / 2, colMid = (left + right) / 2;
        return new Node(false, false, build(grid, top, rowMid, left, colMid),
                build(grid, top, rowMid, colMid + 1, right),
                build(grid, rowMid + 1, bottom, 0, colMid),
                build(grid, rowMid + 1, bottom, colMid + 1, right));
    }

}
