BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS landmarks;
DROP TABLE IF EXISTS itineraries;
DROP TABLE IF EXISTS itinerary_landmarks;
DROP TABLE IF EXISTS user_itinerary;

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
	name varchar(50) NOT NULL UNIQUE,
	street varchar (100) NOT NULL,
	house_number varchar(12),
	postal_code varchar (10) NOT NULL,
    city varchar(50) NOT NULL,
    country varchar(50) NOT NULL,
	latitude_coordinates decimal NOT NULL,
	longitude_coordinates decimal NOT NULL,
	image_name varchar(255) NOT NULL,
	description varchar(500) NOT NULL,
	historic_details varchar(500),
	cost_of_entry decimal,
	duration varchar,
	reviews varchar(500),
	CONSTRAINT PK_landmark PRIMARY KEY (landmark_id)
);

CREATE TABLE itineraries (
	itinerary_id SERIAL,
	itinerary_name varchar(50),
	starting_location_address varchar(75),
	starting_location_latitude decimal,
	starting_location_longitude decimal,
	CONSTRAINT PK_itinerary PRIMARY KEY (itinerary_id)
);

CREATE TABLE itinerary_landmarks (
    itinerary_landmark_id SERIAL PRIMARY KEY,
    itinerary_id INT REFERENCES itineraries(itinerary_id),
    landmark_id INT REFERENCES landmarks(landmark_id)
);

CREATE TABLE user_itinerary (
    user_itineraries_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(user_id),
    itinerary_id INT REFERENCES itineraries(itinerary_id)
);

CREATE TABLE landmark_images (
    image_id SERIAL PRIMARY KEY,
    image_url VARCHAR(512) NOT NULL,
    user_id INT REFERENCES users(user_id),
    landmark_id INT REFERENCES landmarks(landmark_id),
    upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMIT TRANSACTION;
