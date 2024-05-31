package com.study.springstudy.springmvc.util;

import javax.servlet.http.HttpSession;

public class LoginUtil {

    public static final String LOGIN = "login";

    // �α��� ���� Ȯ��
    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute(LOGIN) != null;
    }
}
