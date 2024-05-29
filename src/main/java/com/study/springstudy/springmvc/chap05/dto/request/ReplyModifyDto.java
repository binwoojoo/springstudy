package com.study.springstudy.springmvc.chap05.dto.request;

import com.study.springstudy.springmvc.chap05.entity.Reply;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplyModifyDto {

    @NotNull
    private long rno; // ������ ����� ��� ��ȣ
    @NotBlank
    private String newText; // ���ο� ��� ����
    @NotNull
    private long bno; // ���� �Ϸ� �� ���ο� ��� ��ȸ�ϱ� ����

    // ����Ƽ�� ��ȯ�ϴ� �޼���
    public Reply toEntity() {
        return Reply.builder()
                .replyText(this.newText)
                .replyNo(this.rno)
                .boardNo(this.bno)
                .build();
    }
}
