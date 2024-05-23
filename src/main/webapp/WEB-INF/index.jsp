<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>Web Study</title>
    <style>
      body {
        background: url('/assets/img/스펀지.webp') center/cover;
        background-size: contain;
      }
      /* .menu {
        width: 100%;
        height: 95vh;
      } */
    </style>
  </head>
  <body>
    <div class="menu">
    <h1>hello!!! JSP</h1>

    <a href="/chap01/join">회원가입하기</a> <br />
    <a href="/chap02/v1/join">회원가입하기(front v1)</a> <br />
    <a href="/chap02/v2/join">회원가입하기(front v2)</a> <br />
    <a href="/chap02/v3/join">회원가입하기(front v3)</a> <br />
    <a href="/chap02/v4/join">회원가입하기(front v4)</a> <br />
    <a href="/chap02/v5/join">회원가입하기(front v5)</a> <br />
    <a href="/score/list">성적정보 관리 프로그램</a> <br />
    <a href="/board/list">게시물 관리 프로그램</a> <br />

  </div>
  </body>
</html>
