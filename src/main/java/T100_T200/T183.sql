SELECT DISTINCT c.Name Customers
FROM Customers c
WHERE c.Id NOT IN (SELECT DISTINCT o.CustomerId
                   FROM Orders o)