DROP TABLE IF EXISTS teachers        cascade;
DROP TABLE IF EXISTS students        cascade;
DROP TABLE IF EXISTS administrators  cascade;
DROP TABLE IF EXISTS rooms           cascade;
DROP TABLE IF EXISTS announcements   cascade;
DROP TABLE IF EXISTS detentions      cascade;
DROP TABLE IF EXISTS grade_levels    cascade;
DROP TABLE IF EXISTS classes         cascade;
DROP TABLE IF EXISTS teacher        cascade;
DROP TABLE IF EXISTS student        cascade;
DROP TABLE IF EXISTS admin  cascade;
DROP TABLE IF EXISTS room           cascade;
DROP TABLE IF EXISTS announcement   cascade;
DROP TABLE IF EXISTS detention      cascade;
DROP TABLE IF EXISTS grade_level    cascade;
DROP TABLE IF EXISTS class         cascade;
DROP TABLE IF EXISTS teachers_classes cascade;

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

CREATE TABLE detentions (
    detention_id serial NOT NULL,
    student_id int NOT NULL,
    CONSTRAINT pk_detention_detention_id PRIMARY KEY (detention_id)
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

ALTER TABLE students
ADD CONSTRAINT FK_students_classes
FOREIGN KEY (class_id) REFERENCES classes(class_id);

ALTER TABLE detentions
ADD CONSTRAINT FK_detentions_students
FOREIGN KEY (student_id) REFERENCES students(student_id);

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