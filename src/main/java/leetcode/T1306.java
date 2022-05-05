package leetcode;

public class T1306 {

    private boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        return dfs(arr, start);
    }

    private boolean dfs(int[] arr, int index) {
        if (arr[index] == 0) return true;
        boolean res = false;
        if (index + arr[index] < arr.length && !visited[index + arr[index]]) {
            visited[index] = true;
            res |= dfs(arr, index + arr[index]);
        }
        if (index - arr[index] >= 0 && !visited[index - arr[index]]) {
            visited[index] = true;
            res |= dfs(arr, index - arr[index]);
        }
        return res;

    }

}
