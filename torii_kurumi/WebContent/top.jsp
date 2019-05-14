<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>家計簿サイト</title>
    </head>
    <body>
        <div class="main-contents">
            <div class="header">
    <c:if test="${ empty loginUser }">
        <a href="login">ログイン</a>
        <a href="settings.jsp">ユーザー新規登録</a>

    </c:if>
    <c:if test="${ not empty loginUser }">
        <a href="./">ホーム</a>
        <a href="logout">ログアウト</a>
        <a href="settings.jsp">ユーザー新規登録</a>
        <a href="edit.jsp">ユーザー管理画面</a>
        <a href="calendar.jsp">カレンダー</a>
        <a href="guraph.jsp">グラフ</a>
    </c:if>
</div>
<c:if test="${ not empty loginUser }">
    <div class="profile">
        <div class="name"><h2><c:out value="${loginUser.name}" /></h2></div>
        <div class="accountid">
            @<c:out value="${loginUser.accountid}" />
        </div>
    </div>
</c:if>

            <div class="copyright"> Copyright(c)Kurumi Torii</div>
        </div>
    </body>
</html>