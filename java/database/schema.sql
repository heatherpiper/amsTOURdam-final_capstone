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
	name varchar(50) NOT NULL,
	address varchar(200) NOT NULL,
	latitude_coordinates decimal(8,6) NOT NULL,
	longitude_coordinates decimal(9,6) NOT NULL,
	image_name varchar(255) NOT NULL,
	description varchar(200) NOT NULL,
	historic_details varchar(200) NOT NULL,
	cost_of_entry decimal(2,2),
	CONSTRAINT PK_landmark PRIMARY KEY (landmark_id)
);

COMMIT TRANSACTION;
