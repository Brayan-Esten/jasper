CREATE TABLE IF NOT EXISTS departments (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS employees (
    id SERIAL PRIMARY KEY,
	department_id INT NOT NULL REFERENCES departments(id) ON DELETE SET NULL,
    name VARCHAR(150) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL CHECK (salary >= 0),
    joined_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS job_histories (
    id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL REFERENCES employees(id) ON DELETE CASCADE,
    previous_job_id INT REFERENCES job_histories(id) ON DELETE SET NULL,
    position VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL CHECK (salary >= 0),
    start_date DATE NOT NULL,
    end_date DATE
);

CREATE TABLE IF NOT EXISTS performance_evaluations (
    id SERIAL PRIMARY KEY,
    employee_id INT NOT NULL REFERENCES employees(id) ON DELETE CASCADE,
	review_date DATE NOT NULL,
    rating INT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    feedback TEXT
);


