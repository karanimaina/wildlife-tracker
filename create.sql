CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
CREATE TABLE animals(id  serial PRIMARY KEY,name varchar, age varchar,health varchar );
ALTER TABLE  animals ADD COLUMN type varchar;
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;