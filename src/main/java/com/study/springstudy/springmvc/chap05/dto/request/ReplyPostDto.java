package com.study.springstudy.springmvc.chap05.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplyPostDto {

    /*
     NOT NUll: NULL만 허용안됨
     NOT EMPTY: NULL은 되는데 빈문자는 안됨
     NOT BLANK: NULL도 안되고 빈문자도 안됨
     */

    @NotNull
    private long bno; // 원본 글번호

    @NotBlank
    @Size(min = 1, max = 300)
    private String text; // 댓글 내용

    @NotBlank
    @Size(min = 2, max = 8)
    private String author; // 댓글 작성자

}
