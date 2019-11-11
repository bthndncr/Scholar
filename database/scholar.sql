DROP TABLE IF EXISTS teachers        cascade;
DROP TABLE IF EXISTS students        cascade;
DROP TABLE IF EXISTS administrators  cascade;
DROP TABLE IF EXISTS rooms           cascade;
DROP TABLE IF EXISTS announcements   cascade;
DROP TABLE IF EXISTS detentions      cascade;
DROP TABLE IF EXISTS grade_levels    cascade;
DROP TABLE IF EXISTS classes         cascade;
DROP TABLE IF EXISTS teacher         cascade;
DROP TABLE IF EXISTS student         cascade;
DROP TABLE IF EXISTS admin           cascade;
DROP TABLE IF EXISTS room            cascade;
DROP TABLE IF EXISTS announcement    cascade;
DROP TABLE IF EXISTS detention       cascade;
DROP TABLE IF EXISTS grade_level     cascade;
DROP TABLE IF EXISTS class           cascade;
DROP TABLE IF EXISTS teachers_classes cascade;
DROP TABLE IF EXISTS grades          cascade;
DROP TABLE IF EXISTS assignments     cascade;
DROP TABLE IF EXISTS grades_assignments cascade;
DROP TABLE IF EXISTS logs            cascade;
DROP TABLE IF EXISTS disciplines     cascade;
DROP TABLE IF EXISTS teachers_logs   cascade;

CREATE TABLE teachers (
    teacher_id serial NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    phone_number varchar(10) NOT NULL,
    email varchar NOT NULL,
    class_id int NOT NULL,
    CONSTRAINT pk_teacher_teacher_id PRIMARY KEY (teacher_id)
);

CREATE TABLE students (
    student_id serial NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    phone_number varchar(10) NOT NULL,
    email varchar NOT NULL,
    class_id int NOT NULL,
    CONSTRAINT pk_student_student_id PRIMARY KEY (student_id)
);

CREATE TABLE administrators (
    administrator_id serial NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    phone_number varchar(10) NOT NULL,
    email varchar NOT NULL,
    CONSTRAINT pk_administrator_administrator_id PRIMARY KEY (administrator_id)
);

CREATE TABLE classes (
    class_id serial NOT NULL,
    class_code varchar NOT NULL,
    room_code int NOT NULL,
    CONSTRAINT pk_class_class_id PRIMARY KEY (class_id)
);

CREATE TABLE rooms (
    room_code serial NOT NULL,
    class_id int NOT NULL,
    CONSTRAINT pk_room_room_code PRIMARY KEY (room_code)
);

CREATE TABLE announcements (
    announcement_id serial NOT NULL,
    announcement_code int NOT NULL,
    announcement_name varchar NOT NULL,
    date_annoucement_made timestamp without time zone NOT NULL,
    date_of_event date,
    administrator_id int NOT NULL,
    CONSTRAINT pk_announcement_announcement_id PRIMARY KEY (announcement_id)
);

CREATE TABLE teachers_classes (
    teacher_id serial NOT NULL,
    class_id serial NOT NULL,
    CONSTRAINT pk_teacher_id_class_id PRIMARY KEY (teacher_id, class_id)
);

CREATE TABLE grades (
    grade_id serial NOT NULL,
    assignment_id int NOT NULL,
    student_id int NOT NULL,
    points_earned decimal(5, 2),
    CONSTRAINT PK_grades_grade_id PRIMARY KEY (grade_id)
);

CREATE TABLE assignments (
    assignment_id serial NOT NULL,
    title varchar NOT NULL,
    points_possible int,
    date_assigned date,
    date_due date,
    class_id int NOT NULL,
    CONSTRAINT PK_assignments_assignment_id PRIMARY KEY (assignment_id)
);

CREATE TABLE grades_assignments (
    grade_id int NOT NULL,
    assignment_id int NOT NULL,
    CONSTRAINT PK_grades_assignments_grade_id_assignment_id PRIMARY KEY (grade_id, assignment_id)
);

CREATE TABLE disciplines (
    discipline_id serial NOT NULL,
    student_id int NOT NULL,
    discipline_code varchar NOT NULL,
    discipline_date date NOT NULL,
    administrator_id int,
    teacher_id int,
    CONSTRAINT PK_disciplines_discipline_id PRIMARY KEY (discipline_id)
);

CREATE TABLE logs (
    log_id serial NOT NULL,
    log_name varchar NOT NULL,
    CONSTRAINT PK_logs_log_id PRIMARY KEY (log_id)
);

CREATE TABLE teachers_logs (
    teacher_id int NOT NULL,
    log_id int NOT NULL,
    CONSTRAINT PK_teachers_teacher_id_logs_log_id PRIMARY KEY (teacher_id, log_id)
);

ALTER TABLE grades_assignments
ADD CONSTRAINT FK_grades_grades_assignments
FOREIGN KEY (grade_id) REFERENCES grades(grade_id);

ALTER TABLE grades_assignments
ADD CONSTRAINT FK_assignments_grades_assignments
FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id);

ALTER TABLE students
ADD CONSTRAINT FK_students_classes
FOREIGN KEY (class_id) REFERENCES classes(class_id);

ALTER TABLE disciplines
ADD CONSTRAINT FK_detentions_students
FOREIGN KEY (student_id) REFERENCES students(student_id);

ALTER TABLE disciplines
ADD CONSTRAINT FK_detentions_teachers
FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id);

ALTER TABLE disciplines
ADD CONSTRAINT FK_detentions_administrators
FOREIGN KEY (administrator_id) REFERENCES administrators(administrator_id);

ALTER TABLE announcements
ADD CONSTRAINT FK_announcements_administrator
FOREIGN KEY (administrator_id) REFERENCES administrators(administrator_id);

ALTER TABLE teachers_classes
ADD CONSTRAINT FK_teachers_teachers_classes
FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id);

ALTER TABLE teachers_classes
ADD CONSTRAINT FK_classes_teachers_classes
FOREIGN KEY (class_id) REFERENCES classes(class_id);

ALTER TABLE classes
ADD CONSTRAINT FK_classes_rooms
FOREIGN KEY (room_code) REFERENCES rooms(room_code);

ALTER TABLE teachers_logs
ADD CONSTRAINT FK_teachers_teachers_logs
FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id);

ALTER TABLE teachers_logs
ADD CONSTRAINT FK_logs_teachers_logs
FOREIGN KEY (log_id) REFERENCES logs(log_id);

ALTER TABLE grades
ADD CONSTRAINT FK_grades_assignments
FOREIGN KEY (assignment_id) REFERENCES assignments(assignment_id);

ALTER TABLE assignments
ADD CONSTRAINT FK_assignments_classes
FOREIGN KEY (class_id) REFERENCES classes(class_id);


-- for gradebook, the sql will be something like:
-- SELECT * from gradebook where assignment_id=10 group by letter_grade order by letter_grade desc;
-- when viewing grades on an assignment, we want it to return a list of students and the grade they
-- received on the selected assignment.