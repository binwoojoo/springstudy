package com.study.springstudy.springmvc.chap04.common;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Search extends Page {
    // 검색어, 검색 조건
    private String keyword, type;

    public Search() {
        this.keyword = "";
        this.type = getType();
    }

}
