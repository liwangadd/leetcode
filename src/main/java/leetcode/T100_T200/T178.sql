SELECT
  s.Score,
  (SELECT count(DISTINCT Score) + 1
   FROM Scores
   WHERE Score > s.Score) AS Rank
FROM Scores s
ORDER BY s.Score DESC;