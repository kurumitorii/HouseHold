<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${members.name}の設定</title>
        <link href="css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>

    <center>

    <font face="HGS明朝B" size="8" color="#00008b" class=h4>${member.name}編集画面</font>

    <%=request.getAttribute("id")%>


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

            <form action="edit" method="post"><br />

                <label for="name">名前</label>
                <input name="name" value="${members.name}" id="name"/><br />

                <label for="accountid">アカウントID</label>
				<input name="accountid" value="${members.accountid}" /><br />

                <label for="password">パスワード</label>
                <input name="password" type="password" id="password"/> <br />

                <label for="passwordConfirm">パスワード(確認用)：</label>
                <input name="passwordConfirm" type="password" id="passwordConfirm" > <br /><br />


                <input type="submit" value="変更" /> <br />
                <a href="setting">戻る</a>
            </form>
            <div class="copyright"> Copyright(c)Kurumi Torii</div>
        </div>
        </center>
    </body>
</html>