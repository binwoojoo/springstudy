package com.study.springstudy.springmvc.chap05.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Auth {

    COMMON("�Ϲ�ȸ��", 1),
    ADMIN("������", 2);

    private String desc; // ���� ����
    private int authNumber; // ���� ��ȣ

}
