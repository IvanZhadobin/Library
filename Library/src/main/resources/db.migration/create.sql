CREATE TABLE libraries (
                           id serial8  PRIMARY KEY,
                           name VARCHAR(30) NOT NULL
);

CREATE TABLE books (
                       id serial8  PRIMARY KEY,
                       title VARCHAR(30) NOT NULL,
                       author VARCHAR(30) NOT NULL,
                       year_published INTEGER NOT NULL,
                       library_id INTEGER
);

ALTER TABLE books
    ADD CONSTRAINT fk_library_id
        FOREIGN KEY (library_id)
            REFERENCES libraries(id)
            ON DELETE CASCADE;
