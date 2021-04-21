package com.springbook.domain;

import java.sql.Date;

// VO(Value Object)
public class BoardVO {

	/*CREATE TABLE tbl_board(
    bno int NOT NULL AUTO_increment,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(2000) NOT NULL,tbl_boardtbl_board
    writer VARCHAR(100) NOT NULL,
    regDate timestamp not null default now(),
    viewCnt int default 0,
    PRIMARY KEY(bno);
	*/
	
	private int bno;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int viewCnt;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	
}
