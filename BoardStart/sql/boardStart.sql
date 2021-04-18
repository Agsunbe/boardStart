CREATE TABLE tbl_board(
    bno int NOT  NULL,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(2000) NOT NULL,
    writer VARCHAR(100) NOT NULL,
    regDate timestamp not null default now(),
    viewCnt int default 0,
    PRIMARY KEY(bno)
);
COMMIT;