-- Ошибки в расписании
SELECT DISTINCT
	films1.name as film1,
	shows1.begin_time as bt1,
	films1.duration as duration1,
	films2.name as film2,
	shows2.begin_time as bt2,
    films2.duration as duration2
FROM 
	films as films1 JOIN shows as shows1 ON films1.id = shows1.film_id
    CROSS JOIN
    films as films2 JOIN shows as shows2 ON films2.id = shows2.film_id
WHERE
	shows1.id <> shows2.id AND
    timestampdiff(MINUTE, shows1.begin_time, shows2.begin_time) >= 0 AND
    timestampdiff(MINUTE, shows1.begin_time, shows2.begin_time) < films1.duration
ORDER BY films1.name;

-- Перерывы в 30 минут и более
SELECT 	f.name,
		t1.begin_time,
        f.duration,
        t2.begin_time as next,
        timestampdiff(MINUTE, t1.begin_time, t2.begin_time) - f.duration as gap
	FROM
		(
			SELECT ROW_NUMBER() OVER(ORDER BY begin_time) number, begin_time, film_id
			FROM shows
		) AS t1
	JOIN
			(
				SELECT ROW_NUMBER() OVER(ORDER BY begin_time) number, begin_time
				FROM shows
			) AS t2
		ON t1.number + 1 = t2.number
    JOIN
			(
				SELECT id, name, duration from films
			) f
		ON t1.film_id = f.id
    WHERE timestampdiff(MINUTE, t1.begin_time, t2.begin_time) - f.duration >= 30
    ORDER BY t1.number;
  
	