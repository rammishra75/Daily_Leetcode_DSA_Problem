# Write your MySQL query statement below
SELECT
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
    -- Note: SQL Server Use `[rank]` instead of `rank`.
FROM Scores
ORDER BY score DESC;