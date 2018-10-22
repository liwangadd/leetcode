DELETE FROM
  Person
WHERE
  Id NOT IN (SELECT Id
             FROM
               (SELECT min(Id) AS Id
                FROM Person
                GROUP BY Email
               ) p
  );