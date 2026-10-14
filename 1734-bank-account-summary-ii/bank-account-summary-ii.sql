# Write your MySQL query statement below
SELECT
    u.name as NAME,
    SUM(t.amount) as BALANCE
FROM
    Users u
JOIN 
    Transactions t 
ON 
    u.account = t.account
GROUP BY
    t.account
HAVING 
    BALANCE > 10000;