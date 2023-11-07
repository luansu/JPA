--drop database book_store

CREATE Database book_store
go 
use book_store
go

CREATE TABLE books(
	bookid int primary key,
	isbn int,
	title varchar(200),
	publisher varchar(200),
	price decimal(6,2),
	descripion text,
	publish_date date,
	cover_image varchar(100),
	quantity int,
);

CREATE TABLE users(
	id int primary key,
	email varchar(50) not null,
	fullname nvarchar(50),
	phone int,
	passwd varchar(32) not null,
	signup_date datetime,
	last_login datetime,
	is_admin bit,
);

insert into users(id, email, passwd) values(11, '1', '1')
update users set is_admin = 0 where id = 11
CREATE TABLE author(
	authorid int primary key,
	author_name varchar(100),
	date_of_birth date,
);

CREATE TABLE book_author(
	bookid int references books(bookid),
	author_id int references author(authorid),
	constraint pk_book_author primary key(bookid, author_id)
);

CREATE TABLE rating(
	userid int references users(id),
	bookid int references books(bookid),
	rating tinyint,
	review_text text
	constraint pk_book_author primary key(bookid, userid)
);

INSERT INTO books (bookid, isbn, title, publisher, price, descripion, publish_date, cover_image, quantity)
VALUES
  (1, 1890, 'Sample Book 1', 'Sample Publisher 1', 19.99, 'Sample description 1', '2023-01-15', 'cover1.jpg', 50),
  (2, 890, 'Sample Book 2', 'Sample Publisher 2', 24.90, 'Sample description 2', '2023-02-20', 'cover2.jpg', 30),
  (3, 34892, 'Sample Book 3', 'Sample Publisher 3', 14.90, 'Sample description 3', '2023-03-10', 'cover3.jpg', 20),
  (4, 40123, 'Sample Book 4', 'Sample Publisher 4', 29.09, 'Sample description 4', '2023-04-05', 'cover4.jpg', 40),
  (5, 9034, 'Sample Book 5', 'Sample Publisher 5', 39.09, 'Sample description 5', '2023-05-15', 'cover5.jpg', 60),
  (6, 6345, 'Sample Book 6', 'Sample Publisher 6', 12.90, 'Sample description 6', '2023-06-25', 'cover6.jpg', 10),
  (7, 346, 'Sample Book 7', 'Sample Publisher 7', 17.90, 'Sample description 7', '2023-07-30', 'cover7.jpg', 25),
  (8, 8567, 'Sample Book 8', 'Sample Publisher 8', 27.90, 'Sample description 8', '2023-08-15', 'cover8.jpg', 35),
  (9, 9578, 'Sample Book 9', 'Sample Publisher 9', 22.0, 'Sample description 9', '2023-09-05', 'cover9.jpg', 15),
  (10, 120, 'Sample Book 10', 'Sample Publisher 10', 34.90, 'Sample description 10', '2023-10-10', 'cover10.jpg', 45);

INSERT INTO users (id, email, fullname, phone, passwd, signup_date, last_login, is_admin)
VALUES
  (1, 'user1@example.com', 'John Doe', 123890, 'password1', '2023-01-01 08:00:00', '2023-11-06 15:30:00', 0),
  (2, 'user2@example.com', 'Jane Smith', 234901, 'password2', '2023-02-05 10:15:00', '2023-11-06 13:45:00', 0),
  (3, 'user3@example.com', 'Alice Johnson', 379012, 'password3', '2023-03-10 11:30:00', '2023-11-06 09:20:00', 1),
  (4, 'user4@example.com', 'Bob Williams', 489023, 'password4', '2023-04-15 13:45:00', '2023-11-06 12:00:00', 0),
  (5, 'user5@example.com', 'Eve Davis', 57234, 'password5', '2023-05-20 15:00:00', '2023-11-06 14:10:00', 0),
  (6, 'user6@example.com', 'Charlie Brown', 912345, 'password6', '2023-06-25 17:20:00', '2023-11-06 11:30:00', 0),
  (7, 'user7@example.com', 'Lucy Miller', 783456, 'password7', '2023-07-01 19:45:00', '2023-11-06 16:40:00', 0),
  (8, 'user8@example.com', 'David Lee', 891567, 'password8', '2023-08-05 20:30:00', '2023-11-06 10:15:00', 0),
  (9, 'user9@example.com', 'Grace Turner', 94678, 'password9', '2023-09-10 22:00:00', '2023-11-06 18:00:00', 0),
  (10, 'admin@example.com', 'Admin User', 943210, 'adminpass', '2023-10-15 23:59:59', '2023-11-06 08:00:00', 1);

INSERT INTO author (authorid, author_name, date_of_birth)
VALUES
  (1, 'Author 1', '1990-03-15'),
  (2, 'Author 2', '1985-07-20'),
  (3, 'Author 3', '1978-11-10'),
  (4, 'Author 4', '1995-02-05'),
  (5, 'Author 5', '1980-06-25'),
  (6, 'Author 6', '1989-04-30'),
  (7, 'Author 7', '1975-09-01'),
  (8, 'Author 8', '1987-12-05'),
  (9, 'Author 9', '1992-01-10'),
  (10, 'Author 10', '1998-04-15');

INSERT INTO book_author (bookid, author_id)
VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5),
  (6, 6),
  (7, 7),
  (8, 8),
  (9, 9),
  (10, 10);

INSERT INTO rating (userid, bookid, rating, review_text)
VALUES
  (1, 1, 4, 'A great book! I highly recommend it.'),
  (2, 2, 5, 'One of the best books Ive ever read.'),
  (3, 3, 3, 'Decent book, but not my favorite.'),
  (4, 4, 4, 'Enjoyable read with a good storyline.'),
  (5, 4, 5, 'Couldnt put it down. Must-read!'),
  (6, 6, 2, 'Not my cup of tea. I found it boring.'),
  (7, 4, 4, 'Well-written and engaging.'),
  (8, 8, 4, 'Solid book, worth the read.'),
  (9, 4, 3, 'Good book, but nothing extraordinary.'),
  (10, 10, 5, 'An excellent book with a compelling plot.');

select * from books
select * from author
select * from book_author
select * from users
select * from rating