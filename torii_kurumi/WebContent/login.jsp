<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン</title>
    </head>
    <body>
    <center><font face="HGS明朝B" size="8" color="#00008b" class=h4>ログイン</font></center>
        <div class="main-contents">



            <c:if test="${ not empty errorMessages }">
                <div class="errorMessages">
                    <ul>
                        <c:forEach items="${errorMessages}" var="message">
                            <li><c:out value="${message}" />
                        </c:forEach>
                    </ul>
                </div>
                <c:remove var="errorMessages" scope="session"/>
            </c:if>

            <form action="login" method="post"><br />

                <center><label for="accountid">ID</label></center>
                <center><input name="accountid" value="${User.accountid}"id="accountid"/></center> <br />

                <center><label for="password">パスワード</label></center>
                <center><input name="password" type="password" id="password"/></center> <br />

                <center><input type="submit" value="ログイン" /></center> <br />

            </form>
            <center><div class="copyright"> Copyright(c)Kurumi Torii</div></center>
        </div>
    </body>
</html>