package leetcode.T600_T700;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class T690 {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> id2Employee = new HashMap<>();
        for (Employee employee : employees) {
            id2Employee.put(employee.id, employee);
        }
        Queue<Integer> ids = new LinkedList<>();
        ids.add(id);
        int res = 0;
        while (!ids.isEmpty()) {
            Integer empId = ids.poll();
            res += id2Employee.get(empId).importance;
            if (id2Employee.get(empId).subordinates != null)
                ids.addAll(id2Employee.get(empId).subordinates);
        }
        return res;
    }

}
