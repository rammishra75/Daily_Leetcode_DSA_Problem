# Write your MySQL query statement below
SELECT
    customer_id
FROM    
    customer_transactions
GROUP BY
    customer_id
HAVING     
    COUNT(CASE WHEN transaction_type = 'purchase' THEN transaction_id END) >= 3
    AND DATEDIFF(MAX(transaction_date), MIN(transaction_date)) >= 30  AND (COUNT(CASE WHEN transaction_type = 'refund' THEN transaction_id END) * 1.0 / COUNT(transaction_id)) * 100 < 20  
ORDER BY
    customer_id;