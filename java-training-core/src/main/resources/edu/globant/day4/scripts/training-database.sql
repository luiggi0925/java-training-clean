DROP DATABASE training;
CREATE DATABASE training;
USE training;
CREATE TABLE contact (
id INT PRIMARY KEY AUTO_INCREMENT,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(50),
birthday DATE,
creationDate DATETIME
);
INSERT INTO contact VALUES (NULL, 'Pedro', 'Morocco', '1988-11-20', NOW());
INSERT INTO contact VALUES (NULL, 'Pierina', 'Sotomayor', '1979-03-16', NOW());
SELECT * FROM contact;
UPDATE contact SET birthday = '1979-04-16' WHERE id = 2;
SELECT * FROM contact;
DELETE FROM contact WHERE id = 1;
SELECT * FROM contact;

CREATE TABLE contactDetails (
id INT PRIMARY KEY AUTO_INCREMENT,
contactId INT NOT NULL,
contactDetailType INT NOT NULL,
details VARCHAR(100) NOT NULL,
creationDate DATETIME,
FOREIGN KEY (contactId) REFERENCES contact(id)
);

CREATE TABLE contactDetailType (
id INT PRIMARY KEY AUTO_INCREMENT,
description VARCHAR(20)
);

ALTER TABLE contactDetails
ADD FOREIGN KEY (contactDetailType) REFERENCES contactDetailType(id);

INSERT INTO contactDetailType (description) VALUES
('phone'),
('email'),
('address'),
('fax');

SELECT * FROM contactDetailType;
SELECT * FROM contactDetails;
SELECT * FROM contact;
