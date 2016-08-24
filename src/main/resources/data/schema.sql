DROP TABLE Account IF EXISTS;

CREATE TABLE Account (
	id int primary key,
	name varchar(50),
	pwd varchar(50),
	role varchar(50)
);