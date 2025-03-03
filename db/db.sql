-- CREATE USER formbuilder WITH PASSWORD <password>;
-- CREATE DATABASE formbuilder WITH OWNER formbuilder;

CREATE TABLE question_types (
    id SERIAL,
    description VARCHAR (20) UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO question_types (description) VALUES
('TEXT'), ('SINGLE CHOICE'), ('MULTIPLE CHOICE'), ('YES/NO'), ('CHECKBOX');

CREATE TABLE forms (
    id SERIAL,
    name VARCHAR (50),
    PRIMARY KEY (id)
);

CREATE TABLE questions (
    id SERIAL,
    text TEXT,
    question_type_id INTEGER NOT NULL,
    form_id INTEGER NOT NULL,
    question_order INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (question_type_id) REFERENCES question_types (id),
    FOREIGN KEY (form_id) REFERENCES forms (id)
);

CREATE TABLE answer_choices (
    id SERIAL,
    text TEXT,
    question_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES questions (id)
);

CREATE TABLE form_response (
    id SERIAL,
    form_id INTEGER NOT NULL,
    response_timestamp TIMESTAMP NOT NULL DEFAULT NOW(),
    login VARCHAR (50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (form_id) REFERENCES forms (id)
);

CREATE TABLE answers (
    id SERIAL,
    form_response_id INTEGER NOT NULL,
    question_id INTEGER NOT NULL,
    text_answer TEXT,
    boolean_answer BOOLEAN,
    answer_choice_id INTEGER,
    PRIMARY KEY (id),
    FOREIGN KEY (form_response_id) REFERENCES form_response (id),
    FOREIGN KEY (question_id) REFERENCES questions (id),
    FOREIGN KEY (answer_choice_id) REFERENCES answer_choices (id)
);
