WITH RankedScores AS (
    SELECT 
        student_id,
        subject,
        score,
        -- Get the score of the earliest exam date for this student and subject
        FIRST_VALUE(score) OVER (
            PARTITION BY student_id, subject 
            ORDER BY exam_date ASC
        ) AS first_score,
        -- Get the score of the latest exam date for this student and subject
        FIRST_VALUE(score) OVER (
            PARTITION BY student_id, subject 
            ORDER BY exam_date DESC
        ) AS latest_score,
        -- Count how many times the student took the exam in this subject
        COUNT(exam_date) OVER (
            PARTITION BY student_id, subject
        ) AS exam_count
    FROM Scores
)
SELECT DISTINCT
    student_id,
    subject,
    first_score,
    latest_score
FROM RankedScores
WHERE exam_count >= 2           -- Condition 1: Taken at least two exams
  AND latest_score > first_score -- Condition 2: Latest score is higher than the first score
ORDER BY 
    student_id ASC, 
    subject ASC;
