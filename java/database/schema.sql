BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landmarks (
    landmark_id SERIAL,
    category varchar(50),
	name varchar(50) NOT NULL,
	street varchar (100) NOT NULL,
	house_number integer NOT NULL,
	postal_code varchar (10) NOT NULL,
	city varchar (50) NOT NULL,
	latitude_coordinates decimal NOT NULL,
	longitude_coordinates decimal NOT NULL,
	image_name varchar(255) NOT NULL,
	description varchar(200) NOT NULL,
	historic_details varchar(200) NOT NULL,
	cost_of_entry decimal,
	duration decimal,
	reviews varchar(500),
	CONSTRAINT PK_landmark PRIMARY KEY (landmark_id)
);

COMMIT TRANSACTION;
