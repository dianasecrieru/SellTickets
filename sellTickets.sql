CREATE DATABASE sellTicketsDB;

USE sellTicketsDB;

INSERT INTO event VALUES(1, STR_TO_DATE('15-10-2017', '%d-%m-%Y'), 'Concert', 'Iasi', 'Mozart, Bethoven', 25.99, 'Muzica clasica');
INSERT INTO event VALUES(2, STR_TO_DATE('25-11-2017', '%d-%m-%Y'), 'Concert', 'Bucuresti', 'Concert rock', 52.99, 'Muzica rock');
INSERT INTO event VALUES(3, STR_TO_DATE('20-11-2017', '%d-%m-%Y'), 'Concert', 'Timisoara', 'Concert pop', 38.99, 'Muzica pop');
INSERT INTO event VALUES(4, STR_TO_DATE('25-12-2017', '%d-%m-%Y'), 'Concert', 'Iasi', 'Colinde de Craciun', 38.99, 'Muzica pop');

INSERT INTO user VALUES(1, 'Alex', '123');
INSERT INTO user VALUES(2, 'Alin', '333');
INSERT INTO user VALUES(3, 'Marius', '222');

SELECT * FROM event;
SELECT * FROM ticket;
SELECT * FROM user;