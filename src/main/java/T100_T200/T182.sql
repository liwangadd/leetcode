SELECT p.Email
FROM Person p
GROUP BY p.Email
HAVING count(1) > 1