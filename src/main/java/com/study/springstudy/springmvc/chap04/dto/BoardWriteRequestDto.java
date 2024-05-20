package com.study.springstudy.springmvc.chap04.dto;

import com.study.springstudy.springmvc.chap04.entity.Board;

// dto의 필드명은 반드시 html form태그의 입력 태그들 name속성과 일치해야함
// 역할: 브라우저가 전달한 정보를 포장하는 객체
public class BoardWriteRequestDto {

    private String writer;
    private String title;
    private String content;

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Board toEntity() {
        Board b = new Board();
        b.setContent(this.content);
        b.setWriter(this.writer);
        b.setTitle(this.title);
        return b;
    }

}
