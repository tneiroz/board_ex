
drop table if exists board_tbl;

create table board_tbl(
 bno int auto_increment primary key,
 title varchar(300) not null,
 content text not null,
 writer varchar(50) not null,
 regDate timestamp default current_timestamp,
 updateDate timestamp default current_timestamp

);

insert into board_tbl(title,content,writer) values('게시물 제목입니다1.' , '잠이온다1' , '잠꾸러기1');
insert into board_tbl(title,content,writer) values('게시물 제목입니다2.' , '잠이온다2' , '잠꾸러기2');
insert into board_tbl(title,content,writer) values('게시물 제목입니다3.' , '잠이온다3' , '잠꾸러기3');