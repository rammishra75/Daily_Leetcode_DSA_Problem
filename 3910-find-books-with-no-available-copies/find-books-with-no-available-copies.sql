# Write your MySQL query statement below
SELECT
    b.book_id,
    l.title,
    l.author,
    l.genre,
    l.publication_year,
    COUNT(record_id) as current_borrowers
FROM
    library_books l
JOIN
    borrowing_records b
ON
    l.book_id = b.book_id
WHERE b.return_date IS NULL
GROUP BY
    b.book_id
HAVING
     COUNT(b.record_id) = (SELECT total_copies FROM library_books WHERE book_id = b.book_id)
ORDER BY
    current_borrowers DESC,
    l.title ASC;
