INSERT INTO
    student (id, name)
VALUES
    (1, 'Kim'),
    (2, 'Lee'),
    (3, 'Park')
;

INSERT INTO lecture(id, maximum_number_of_participants)
VALUES (1, 30);

INSERT INTO schedule(id, date, lecture_id)
VALUES (1, '2024-06-28', 1);

INSERT INTO lecture_application(id, student_id, lecture_id, schedule_id)
VALUES (1, 1, 1, 1);