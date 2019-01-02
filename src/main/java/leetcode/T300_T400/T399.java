package leetcode.T300_T400;

import java.util.HashMap;
import java.util.Map;

public class T399 {

    private Map<String, Boolean> visited = new HashMap<>();

    private static class Result {
        boolean isSuccess;
        double res;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (values == null || values.length == 0) return new double[0];
        Map<String, Map<String, Double>> formulaMap = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {
            String[] equation = equations[i];
            Map<String, Double> oneFormula;
            if (!formulaMap.containsKey(equation[0])) {
                oneFormula = new HashMap<>();
                oneFormula.put(equation[1], values[i]);
                formulaMap.put(equation[0], oneFormula);
            } else {
                oneFormula = formulaMap.get(equation[0]);
                oneFormula.put(equation[1], values[i]);
            }

            if (!formulaMap.containsKey(equation[1])) {
                oneFormula = new HashMap<>();
                oneFormula.put(equation[0], 1 / values[i]);
                formulaMap.put(equation[1], oneFormula);
            } else {
                oneFormula = formulaMap.get(equation[1]);
                oneFormula.put(equation[0], 1 / values[i]);
            }
        }

        double[] res = new double[queries.length];
        int index = 0;
        for (String[] query : queries) {
            String p1 = query[0];
            String p2 = query[1];
            visited.clear();
            if (!formulaMap.containsKey(p1) || !formulaMap.containsKey(p2)) {
                res[index] = -1.0;
            } else if (p1.equals(p2)) {
                res[index] = 1.0;
            } else {
                Map<String, Double> formula = formulaMap.get(p1);
                Result result = dfs(formula, formulaMap, p1, p2);
                if (result.isSuccess)
                    res[index] = result.res;
                else
                    res[index] = -1.0;
            }
            ++index;
        }
        return res;
    }

    private Result dfs(Map<String, Double> formula, Map<String, Map<String, Double>> formulaMap, String p1, String p2) {
        visited.put(p1, true);
        Result result = new Result();
        if (formula.containsKey(p2)) {
            result.isSuccess = true;
            result.res = formula.get(p2);
            return result;
        }
        for (String key : formula.keySet()) {
            if (!visited.containsKey(key)) {
                result = dfs(formulaMap.get(key), formulaMap, key, p2);
                if (result.isSuccess) {
                    result.res = formula.get(key) * result.res;
                    return result;
                }
            }
        }
        result.isSuccess = false;
        result.res = -1.0;
        return result;
    }

    public static void main(String[] args) {
        T399 solution = new T399();
        String[][] equations = new String[][]{
                {"a", "b"}, {"c", "d"}
        };
        double[] values = {1.0, 1.0};
        String[][] queries = {
                {"a", "c"}, {"b", "d"}, {"b", "a"}, {"d", "c"}
        };
        for (double v : solution.calcEquation(equations, values, queries)) {
            System.out.println(v);
        }
    }

}
