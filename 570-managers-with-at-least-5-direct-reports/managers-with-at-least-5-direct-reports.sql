# Write your MySQL query statement below
SELECT 
    name 
FROM 
    Employee
WHERE id in (
SELECT managerID
FROM Employee
GROUP BY managerID
HAVING COUNT(*) >= 5);
 