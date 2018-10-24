package T200_T300;

import java.util.Iterator;
import java.util.List;

public class T251 {

    private Iterator<List<Integer>> rowIterator;
    private Iterator<Integer> colIterator;

    public T251(List<List<Integer>> vec2d) {
        rowIterator = vec2d.iterator();
    }

    public int next() {
        if (!hasNext()) return 0;
        return colIterator.next();
    }

    public boolean hasNext() {
        while ((colIterator == null || !colIterator.hasNext()) && rowIterator.hasNext()) {
            colIterator = rowIterator.next().iterator();
        }
        return colIterator != null && colIterator.hasNext();
    }
}
