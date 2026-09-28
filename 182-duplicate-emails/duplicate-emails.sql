# Write your MySQL query statement below
SELECT
    email
FROM 
    Person
Group BY
    email
Having 
    COUNT(*) > 1;