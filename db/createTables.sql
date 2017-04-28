CREATE DATABASE LearningOutDB;

USE LearningOutDB;
CREATE TABLE place (
	id_place 	SERIAL,
	name_place 	VARCHAR(50),
	location 	VARCHAR(50),
	province 	VARCHAR(30),
	postal_code 	INTEGER,
--	main_image 	BIGINT,
	PRIMARY KEY (id_place)
)  ENGINE=INNODB;

CREATE TABLE place_image (
	id_image 	SERIAL,
	id_place 	BIGINT NOT NULL REFERENCES place(id_place),
	url_image 	VARCHAR(255),
	description 	VARCHAR(255),
	PRIMARY KEY (id_image, id_place)
)  ENGINE=INNODB;

