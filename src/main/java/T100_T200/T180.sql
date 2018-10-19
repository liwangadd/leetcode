SELECT DISTINCT l1.Num AS ConsecutiveNums
FROM Logs l1
  JOIN Logs l2 ON l1.Num = l2.Num AND l2.Id = l1.Id + 1
  JOIN logs l3 ON l3.Num = l1.Num AND l3.Id = l1.Id + 2