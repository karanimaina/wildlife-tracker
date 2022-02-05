CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
CREATE TABLE animals(id  serial PRIMARY KEY,name varchar, type varchar );
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;