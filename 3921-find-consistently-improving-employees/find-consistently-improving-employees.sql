WITH ranked_reviews AS (
    SELECT 
        r.employee_id,
        r.rating,
        ROW_NUMBER() OVER (
            PARTITION BY r.employee_id 
            ORDER BY r.review_date DESC, r.review_id DESC
        ) AS rn
    FROM performance_reviews r
),
recent_three AS (
    SELECT 
        employee_id,
        MAX(CASE WHEN rn = 1 THEN rating END) AS r1,
        MAX(CASE WHEN rn = 2 THEN rating END) AS r2,
        MAX(CASE WHEN rn = 3 THEN rating END) AS r3,
        COUNT(*) AS total_reviews
    FROM ranked_reviews
    WHERE rn <= 3
    GROUP BY employee_id
    HAVING total_reviews = 3
)
SELECT 
    e.employee_id,
    e.name,
    (rt.r1 - rt.r3) AS improvement_score
FROM recent_three rt
JOIN employees e ON rt.employee_id = e.employee_id
WHERE rt.r3 < rt.r2 AND rt.r2 < rt.r1
ORDER BY improvement_score DESC, e.name ASC;
