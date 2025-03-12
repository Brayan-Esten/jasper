INSERT INTO departments (name) VALUES 
    ('IT'),
    ('HR'),
    ('Finance'),
    ('Marketing')
ON CONFLICT DO NOTHING;

INSERT INTO employees (name, department_id, salary, joined_date) VALUES 
    ('Alice Johnson', 1, 14000.00, '2020-03-15'),
    ('Bob Smith', 2, 12000.00, '2018-07-22'),
    ('Charlie Brown', 3, 12500.00, '2019-05-10'),
    ('David White', 4, 18000.00, '2017-12-01'),
    ('Frank Miller', 1, 11000.00, '2019-02-20'),
    ('Grace Thompson', 2, 10500.00, '2020-06-01'),
    ('Henry Wilson', 3, 9500.00, '2021-01-10'),
    ('Isabella Martinez', 4, 15500.00, '2018-11-30'),
    ('Jack Carter', 1, 13200.00, '2022-04-15'),
    ('Kelly Roberts', 1, 12500.00, '2020-09-10'),
    ('Liam Evans', 2, 11800.00, '2017-06-05'),
    ('Mia Sanders', 3, 9700.00, '2019-10-20'),
    ('Noah Mitchell', 4, 17800.00, '2016-05-17'),
    ('Olivia Adams', 1, 14000.00, '2021-12-05')
ON CONFLICT DO NOTHING;

INSERT INTO job_histories (employee_id, previous_job_id, position, salary, start_date, end_date) VALUES 
    (1, NULL, 'Software Engineer', 12000.00, '2020-03-15', '2022-06-30'),
    (1, 1, 'Senior Software Engineer', 14000.00, '2022-07-01', NULL),

    (2, NULL, 'HR Assistant', 10000.00, '2018-07-22', '2021-04-15'),
    (2, 2, 'HR Manager', 12000.00, '2021-04-16', NULL),

    (3, NULL, 'Finance Analyst', 11000.00, '2019-05-10', '2022-03-01'),
    (3, 3, 'Senior Finance Analyst', 12500.00, '2022-03-02', NULL),

    (4, NULL, 'Marketing Specialist', 15000.00, '2017-12-01', '2021-08-30'),
    (4, 4, 'Marketing Director', 18000.00, '2021-09-01', NULL),

    (5, NULL, 'Backend Developer', 11000.00, '2019-02-20', NULL),

    (6, NULL, 'HR Coordinator', 10500.00, '2020-06-01', NULL),

    (7, NULL, 'Junior Accountant', 9500.00, '2021-01-10', NULL),

    (8, NULL, 'Marketing Executive', 15500.00, '2018-11-30', NULL),

    (9, NULL, 'Software Engineer', 12500.00, '2020-09-10', NULL),

    (10, NULL, 'HR Consultant', 11800.00, '2017-06-05', '2021-02-28'),
    (10, 10, 'Senior HR Consultant', 13200.00, '2021-03-01', NULL),

    (11, NULL, 'Financial Analyst', 9700.00, '2019-10-20', NULL),

    (12, NULL, 'Marketing Associate', 17800.00, '2016-05-17', '2019-06-30'),
    (12, 12, 'Marketing Lead', 17800.00, '2019-07-01', NULL),

    (13, NULL, 'Business Analyst', 14000.00, '2021-12-05', NULL)
ON CONFLICT DO NOTHING;

INSERT INTO performance_evaluations (employee_id, review_date, rating, feedback) VALUES 
    (1, '2021-06-30', 4, 'Great problem-solving skills.'),
    (1, '2022-06-30', 5, 'Excellent performance and leadership.'),

    (2, '2019-07-22', 3, 'Good communication skills but needs improvement.'),
    (2, '2020-07-22', 4, 'Improved significantly in managing tasks.'),
    (2, '2021-07-22', 5, 'Exceptional leadership and decision-making.'),

    (3, '2020-05-10', 4, 'Strong financial analysis skills.'),
    (3, '2021-05-10', 4, 'Consistent performance, detail-oriented.'),
    (3, '2022-05-10', 5, 'Excellent risk assessment and financial planning.'),

    (4, '2018-12-01', 3, 'Creative ideas but execution needs improvement.'),
    (4, '2019-12-01', 4, 'Better strategic planning.'),
    (4, '2020-12-01', 4, 'Good leadership in the marketing team.'),
    (4, '2021-12-01', 5, 'Outstanding marketing campaigns and innovation.'),

    (5, '2020-02-20', 3, 'Technically skilled but slow in execution.'),
    (5, '2021-02-20', 4, 'Better coding speed and accuracy.'),

    (6, '2021-06-01', 4, 'Organized and professional.'),

    (7, '2022-01-10', 2, 'Needs improvement in accounting knowledge.'),

    (8, '2019-11-30', 5, 'Excellent market analysis skills.'),

    (9, '2021-09-10', 4, 'Reliable and hardworking.'),

    (10, '2018-06-05', 3, 'Could improve in handling conflicts.'),
    (10, '2020-06-05', 4, 'Better performance, good communication skills.'),
    
    (11, '2020-10-20', 4, 'Efficient and knowledgeable in finance.'),

    (12, '2017-05-17', 3, 'Average performance, but creative.'),
    (12, '2019-05-17', 4, 'Improved significantly in marketing strategies.'),

    (13, '2022-12-05', 4, 'Detail-oriented and a good team player.')
ON CONFLICT DO NOTHING;
