DROP user if EXISTS 'manager'@localhost;

CREATE user 'manager'@localhost IDENTIFIED BY '1234';

#SELECT * FROM mysql.user;

GRANT SELECT, INSERT, UPDATE, DELETE ON *.* TO 'manager'@localhost;

SHOW GRANTS FOR 'manager'@localhost;

CREATE DATABASE bbs;

USE bbs;

create table member(
member_id varchar(50) unique not null,
member_pw varchar(100) not null,
member_email varchar(100) not null,
register_date timestamp not null,
user_level integer not null,
primary key (member_id));

insert into member(member_id, member_pw, member_email, register_date, user_level) values ('test', '11', '11@naver.com', now(), 3);

create table board(
board_no BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
member_id varchar(50),
board_title varchar(200) not null,
board_content text not null,
board_hit integer not null default 0,
write_date timestamp not null,
is_notice boolean not null,
primary key (board_no),
foreign key (member_id) references member(member_id) on delete set null);

insert into board(board_no, member_id, board_title, board_content, board_hit, write_date, is_notice) values(default, 'test', '첫 글', '첫글입니다.', default, now(), FALSE);

create table comment(
board_no BIGINT UNSIGNED,
comment_no serial,
comment_parent integer,
comment_depth integer not null,
comment_seq integer not null,
member_id varchar(50) not null,
comment_content text not null,
comment_date timestamp not null,
primary key (comment_no),
foreign key (board_no) references board(board_no) ON DELETE SET null);

insert into comment(board_no, comment_no, comment_parent, comment_depth, comment_seq, member_id, comment_content, comment_date) values (1, default, null, 1, 1, 'test', '첫 번째 댓글', now());
insert into comment(board_no, comment_no, comment_parent, comment_depth, comment_seq, member_id, comment_content, comment_date) values (1, default, null, 1, 1, 'test', '두 번째 댓글', now());
insert into comment(board_no, comment_no, comment_parent, comment_depth, comment_seq, member_id, comment_content, comment_date) values (1, default, 1, 2, 2, 'test', '세 번째 댓글', now());
insert into comment(board_no, comment_no, comment_parent, comment_depth, comment_seq, member_id, comment_content, comment_date) values (1, default, 1, 2, 3, 'test', '네 번째 댓글', now());
insert into comment(board_no, comment_no, comment_parent, comment_depth, comment_seq, member_id, comment_content, comment_date) values (1, default, 2, 2, 1, 'test', '다섯 번째 댓글', now());

select * from comment order by coalesce(comment_parent, comment_no), comment_seq;

