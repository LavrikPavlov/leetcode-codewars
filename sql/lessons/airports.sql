CREATE DATABASE flight_repository;

CREATE TABLE airport
(
    code CHAR(3) PRIMARY KEY ,
    country VARCHAR(256) NOT NULL ,
    city VARCHAR(128) NOT NULL
);

CREATE TABLE aircraft
(
    id SERIAL PRIMARY KEY ,
    model VARCHAR(128) NOT NULL
);

CREATE TABLE seat
(
    aircraft_id INT REFERENCES aircraft (id),
    seat_no VARCHAR(4) NOT NULL ,
    PRIMARY KEY (aircraft_id, seat_no)
);


CREATE TABLE flight
(
    id BIGSERIAL PRIMARY KEY ,
    flight_no VARCHAR(16) NOT NULL ,
    departure_date TIMESTAMP NOT NULL ,
    departure_airport_code CHAR(3) REFERENCES airport(code) NOT NULL ,
    arrival_date TIMESTAMP NOT NULL ,
    arrival_airport_code CHAR(3) REFERENCES airport(code) NOT NULL ,
    aircraft_id INT REFERENCES aircraft (id) NOT NULL ,
    status VARCHAR(32) NOT NULL
);


CREATE TABLE ticket
(
    id BIGSERIAL PRIMARY KEY ,
    passenger_no VARCHAR(32) NOT NULL ,
    passenger_name VARCHAR(128) NOT NULL ,
    flight_id BIGINT REFERENCES flight (id) NOT NULL ,
    seat_no VARCHAR(4) NOT NULL,
    cost NUMERIC(8, 2) NOT NULL
);

CREATE UNIQUE INDEX unique_flight_id_seat_no_idx ON ticket (flight_id, seat_no);

select *
from ticket
where seat_no = 'B1'
  and flight_id = 5;

select count(distinct flight_id) from ticket;
select count(*) from ticket;


insert into airport (code, country, city)
values ('MNK', 'Беларусь', 'Минск'),
       ('LDN', 'Англия', 'Лондон'),
       ('MSK', 'Россия', 'Москва'),
       ('BSL', 'Испания', 'Барселона');

insert into aircraft (model)
values ('Боинг 777-300'),
       ('Боинг 737-300'),
       ('Аэробус A320-200'),
       ('Суперджет-100');

insert into seat (aircraft_id, seat_no)
select id, s.column1
from aircraft
         cross join (values ('A1'), ('A2'), ('B1'), ('B2'), ('C1'), ('C2'), ('D1'), ('D2') order by 1) s;

insert into flight (flight_no, departure_date, departure_airport_code, arrival_date, arrival_airport_code, aircraft_id,
                    status)
values
    ('MN3002', '2020-06-14T14:30', 'MNK', '2020-06-14T18:07', 'LDN', 1, 'ARRIVED'),
    ('MN3002', '2020-06-16T09:15', 'LDN', '2020-06-16T13:00', 'MNK', 1, 'ARRIVED'),
    ('BC2801', '2020-07-28T23:25', 'MNK', '2020-07-29T02:43', 'LDN', 2, 'ARRIVED'),
    ('BC2801', '2020-08-01T11:00', 'LDN', '2020-08-01T14:15', 'MNK', 2, 'DEPARTED'),
    ('TR3103', '2020-05-03T13:10', 'MSK', '2020-05-03T18:38', 'BSL', 3, 'ARRIVED'),
    ('TR3103', '2020-05-10T07:15', 'BSL', '2020-05-10T012:44', 'MSK', 3, 'CANCELLED'),
    ('CV9827', '2020-09-09T18:00', 'MNK', '2020-09-09T19:15', 'MSK', 4, 'SCHEDULED'),
    ('CV9827', '2020-09-19T08:55', 'MSK', '2020-09-19T10:05', 'MNK', 4, 'SCHEDULED'),
    ('QS8712', '2020-12-18T03:35', 'MNK', '2020-12-18T06:46', 'LDN', 2, 'ARRIVED');

insert into ticket (passenger_no, passenger_name, flight_id, seat_no, cost)
values ('112233', 'Иван Иванов', 1, 'A1', 200),
       ('23234A', 'Петр Петров', 1, 'B1', 180),
       ('SS988D', 'Светлана Светикова', 1, 'B2', 175),
       ('QYASDE', 'Андрей Андреев', 1, 'C2', 175),
       ('POQ234', 'Иван Кожемякин', 1, 'D1', 160),
       ('898123', 'Олег Рубцов', 1, 'A2', 198),
       ('555321', 'Екатерина Петренко', 2, 'A1', 250),
       ('QO23OO', 'Иван Розмаринов', 2, 'B2', 225),
       ('9883IO', 'Иван Кожемякин', 2, 'C1', 217),
       ('123UI2', 'Андрей Буйнов', 2, 'C2', 227),
       ('SS988D', 'Светлана Светикова', 2, 'D2', 277),
       ('EE2344', 'Дмитрий Трусцов', 3, 'А1', 300),
       ('AS23PP', 'Максим Комсомольцев', 3, 'А2', 285),
       ('322349', 'Эдуард Щеглов', 3, 'B1', 99),
       ('DL123S', 'Игорь Беркутов', 3, 'B2', 199),
       ('MVM111', 'Алексей Щербин', 3, 'C1', 299),
       ('ZZZ111', 'Денис Колобков', 3, 'C2', 230),
       ('234444', 'Иван Старовойтов', 3, 'D1', 180),
       ('LLLL12', 'Людмила Старовойтова', 3, 'D2', 224),
       ('RT34TR', 'Степан Дор', 4, 'A1', 129),
       ('999666', 'Анастасия Шепелева', 4, 'A2', 152),
       ('234444', 'Иван Старовойтов', 4, 'B1', 140),
       ('LLLL12', 'Людмила Старовойтова', 4, 'B2', 140),
       ('LLLL12', 'Роман Дронов', 4, 'D2', 109),
       ('112233', 'Иван Иванов', 5, 'С2', 170),
       ('NMNBV2', 'Лариса Тельникова', 5, 'С1', 185),
       ('DSA586', 'Лариса Привольная', 5, 'A1', 204),
       ('DSA583', 'Артур Мирный', 5, 'B1', 189),
       ('DSA581', 'Евгений Кудрявцев', 6, 'A1', 204),
       ('EE2344', 'Дмитрий Трусцов', 6, 'A2', 214),
       ('AS23PP', 'Максим Комсомольцев', 6, 'B2', 176),
       ('112233', 'Иван Иванов', 6, 'B1', 135),
       ('309623', 'Татьяна Крот', 6, 'С1', 155),
       ('319623', 'Юрий Дувинков', 6, 'D1', 125),
       ('322349', 'Эдуард Щеглов', 7, 'A1', 69),
       ('DIOPSL', 'Евгений Безфамильная', 7, 'A2', 58),
       ('DIOPS1', 'Константин Швец', 7, 'D1', 65),
       ('DIOPS2', 'Юлия Швец', 7, 'D2', 65),
       ('1IOPS2', 'Ник Говриленко', 7, 'C2', 73),
       ('999666', 'Анастасия Шепелева', 7, 'B1', 66),
       ('23234A', 'Петр Петров', 7, 'C1', 80),
       ('QYASDE', 'Андрей Андреев', 8, 'A1', 100),
       ('1QAZD2', 'Лариса Потемнкина', 8, 'A2', 89),
       ('5QAZD2', 'Карл Хмелев', 8, 'B2', 79),
       ('2QAZD2', 'Жанна Хмелева', 8, 'С2', 77),
       ('BMXND1', 'Светлана Хмурая', 8, 'В2', 94),
       ('BMXND2', 'Кирилл Сарычев', 8, 'D1', 81),
       ('SS988D', 'Светлана Светикова', 9, 'A2', 222),
       ('SS978D', 'Андрей Желудь', 9, 'A1', 198),
       ('SS968D', 'Дмитрий Воснецов', 9, 'B1', 243),
       ('SS958D', 'Максим Гребцов', 9, 'С1', 251),
       ('112233', 'Иван Иванов', 9, 'С2', 135),
       ('NMNBV2', 'Лариса Тельникова', 9, 'B2', 217),
       ('23234A', 'Петр Петров', 9, 'D1', 189),
       ('123951', 'Полина Зверева', 9, 'D2', 234);

SELECT * FROM ticket
WHERE id = 29;

CREATE UNIQUE INDEX unique_flight_id_seat_no_idx ON ticket (flight_id, seat_no);

SELECT * FROM ticket
WHERE id = 29
AND passenger_no = 'DSA581';

EXPLAIN SELECT * FROM ticket; -- ПЛАН ВЫПОЛНЕНИЯ

SELECT reltuples, relkind, relpages
    FROM pg_class WHERE relname = 'ticket';

SELECT avg(bit_length(ticket.passenger_no) / 8),
       avg(bit_length(ticket.passenger_name) / 8),
           avg(bit_length(ticket.seat_no) / 8)
FROM ticket;

-- 8 + 6 + 28 + 8 + 2 + 8  = 60 байт

EXPLAIN SELECT * FROM ticket
                 WHERE passenger_name like 'Иван%'
AND seat_no = 'B1'; -- ПЛАН ВЫПОЛНЕНИЯ

EXPLAIN
SELECT flight_id, count(*), sum(cost) FROM ticket
GROUP BY flight_id;

EXPLAIN SELECT * FROM ticket
WHERE id = 25;

CREATE TABLE test_first(
    id serial primary key,
    num_one int not null,
    num_two int not null,
    value varchar(32) not null
);

CREATE INDEX test_first_num_one_idx ON test_first(num_one);
CREATE INDEX test_first_num_two_idx ON test_first(num_two);

INSERT INTO test_first(num_one, num_two, value)
SELECT random() * generate_series,
       random() * generate_series,
       generate_series
FROM generate_series(1,100000);

SELECT relname,
       reltuples,
       relkind,
       relpages
FROM pg_class
WHERE relname LIKE 'test_first%';

analyse test_first;

EXPLAIN SELECT * FROM test_first WHERE num_one = 1000 OR value = '1234';

-- Index Scan
EXPLAIN SELECT * FROM test_first WHERE num_one = 1000 AND value = '1234';

-- Index Only Scan
EXPLAIN SELECT num_one FROM test_first WHERE num_one = 1000;

EXPLAIN SELECT num_one, num_two FROM test_first WHERE num_one = 1000;

EXPLAIN SELECT *
        FROM test_first
        WHERE num_one < 1000 AND num_one > 90000;

-- Bitmap index scan
EXPLAIN SELECT *
        FROM test_first
        WHERE num_one < 1000 OR num_two > 90000;

-- Bitmap index scan
EXPLAIN ANALYSE
    SELECT *
        FROM test_first
        WHERE num_one < 10000;


CREATE TABLE test_two(
    id serial PRIMARY KEY,
    test1_id int references test_first(id) NOT NULL,
    num_one int not null,
    num_two int not null,
    value varchar(32) not null
);

INSERT INTO test_two (test1_id, num_one, num_two, value)
SELECT id,
       random() * num_one,
       random() * num_two,
       value
FROM test_first;

CREATE INDEX test_two_num_one_ndx on test_two(num_one);
CREATE INDEX test_two_num_two_ndx on test_two(num_two);

-- hash join
EXPLAIN ANALYSE
SELECT *
FROM test_first AS t1
JOIN test_two AS t2 ON t1.id = t2.test1_id;

-- merge join
EXPLAIN ANALYSE
SELECT *
FROM test_first t1
JOIN (SELECT * FROM test_two ORDER BY test1_id) t2 ON t1.id = t2.test1_id
ORDER BY t1.id;

-- Nested Loop with idx {test_two_test1_id_idx}
EXPLAIN ANALYSE
SELECT *
FROM test_first AS t1
JOIN test_two AS t2 ON t1.id = t2.test1_id
LIMIT 100;

EXPLAIN ANALYSE
SELECT *
FROM test_first AS t1
JOIN test_two AS t2 ON t1.id = t2.test1_id
LIMIT 1000;

CREATE INDEX test_two_test1_id_idx ON test_two(test1_id);