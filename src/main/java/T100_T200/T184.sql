SELECT
  d.Name Department,
  e.Name Employee,
  e.Salary
FROM Employee e
  JOIN (SELECT
          MAX(Salary) Salary,
          DepartmentId
        FROM Employee
        GROUP BY DepartmentId) t ON e.Salary = t.Salary AND e.DepartmentId = t.DepartmentId
  JOIN Department d ON e.DepartmentId = d.Id;