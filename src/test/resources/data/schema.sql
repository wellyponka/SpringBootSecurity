DROP TABLE Account IF EXISTS;

CREATE TABLE Account (
	id INTEGER IDENTITY PRIMARY KEY,
	name varchar(50),
	pwd varchar(50),
	role varchar(50)
);