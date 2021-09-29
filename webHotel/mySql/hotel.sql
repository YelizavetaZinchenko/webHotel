CREATE DATABASE hotel;
USE hotel;

CREATE TABLE user (
	id_user INT AUTO_INCREMENT,
	email VARCHAR(45) UNIQUE NOT NULL,
	name VARCHAR(45) NOT NULL,
	isAdmin BOOLEAN NOT NULL,
	password VARCHAR(45) NOT NULL,
	PRIMARY KEY(id_user)
);

CREATE TABLE room(
	id_room INT AUTO_INCREMENT,
	price double,
    amountOfSeats INT,
    classOfRoom VARCHAR(50) NOT NULL,
    statusOfRoom VARCHAR(50) NOT NULL,
    bill BOOLEAN NOT NULL,
	PRIMARY KEY(id_room)
);

CREATE TABLE userRoom (
	id_userRoom INT AUTO_INCREMENT,
	user_id INT NOT NULL,
    room_id INT NOT NULL,
	FOREIGN KEY (user_id) REFERENCES user (id_user),
    FOREIGN KEY (room_id) REFERENCES room (id_room),
	PRIMARY KEY(id_userRoom)
);

CREATE TABLE application (
	id_application INT AUTO_INCREMENT,
    user_id INT NOT NULL,
	price double,
    amountOfSeats INT,
    classOfRoom VARCHAR(50) NOT NULL,
    statusOfRoom VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id_user),
	PRIMARY KEY(id_application)
);

CREATE TABLE confirmationForAdmin (
	id_confirmationForAdmin INT AUTO_INCREMENT,
	user_admin_id INT NOT NULL,
    room_admin_id INT NOT NULL,
	FOREIGN KEY (user_admin_id) REFERENCES user (id_user),
    FOREIGN KEY (room_admin_id) REFERENCES room (id_room),
	PRIMARY KEY(id_confirmationForAdmin)
);

SELECT* FROM user;
SELECT* FROM room;
SELECT* FROM userRoom;
SELECT* FROM application;
SELECT* FROM confirmationForAdmin;

TRUNCATE TABLE user;
TRUNCATE TABLE room;
TRUNCATE TABLE userRoom;
TRUNCATE TABLE application;
TRUNCATE TABLE confirmationForAdmin;

DROP TABLE user;
DROP TABLE room;
DROP TABLE userroom;
DROP TABLE application;
DROP TABLE confirmationforadmin;

INSERT INTO user(email, name, isAdmin, password) VALUES ("zinchenkoelizabeth@gmail.com", "Elizabeth", true, "password");

INSERT INTO room(price, amountOfSeats, classOfRoom, statusOfRoom, bill) VALUES (199, 2, "Luxury", "Empty", false);
INSERT INTO room(price, amountOfSeats, classOfRoom, statusOfRoom, bill) VALUES (99, 4, "Standard", "Empty", false);
INSERT INTO room(price, amountOfSeats, classOfRoom, statusOfRoom, bill) VALUES (89, 3, "Economy", "Empty", false);
INSERT INTO room(price, amountOfSeats, classOfRoom, statusOfRoom, bill) VALUES (99, 4, "Standard", "Empty", false);
INSERT INTO room(price, amountOfSeats, classOfRoom, statusOfRoom, bill) VALUES (89, 1, "Economy", "Empty", false);
