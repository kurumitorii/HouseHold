<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>掲示板</title>
    </head>
    <body>
        <div class="main-contents">
            <div class="header">
    <c:if test="${ empty loginUser }">
        <a href="login">ログイン</a>
    </c:if>
    <c:if test="${ not empty loginUser }">
        <a href="./">ホーム</a>
        <a href="logout">ログアウト</a>
        <a href="newpost">新規投稿</a>

        <form action="setting" method="post">
        <input name="loginUserDeartment" value="${loginUser.department}" id="deartment" type="hidden"/>
        <input type="submit" value="ユーザー管理画面" />
        </form>


        <a href="edit"></a>
    </c:if>
</div>


<font face="HGS明朝B" size="8" color="#00008b" class=h4>掲示板</font>
<c:if test="${ not empty loginUser }">
    <div class="profile">
        <div class="name"><h2><c:out value="${loginUser.name}" /></h2></div>
        <div class="accountid">
            @<c:out value="${loginUser.accountid}" />

<c:if test="${ isShowMessageForm }">
            <form action="./" method="post">
           	カテゴリー検索：<input name="search" value="" id="search" type="text"/><br />
           	日付指定：<input name="datesearch" value="" id="datesearch" type="date"/>～
           	<input name="datesearch2" value="" id="datesearch" type="date"/>
           	</form>
</c:if>

        </div>
    </div>
</c:if>

<br /><br />

<div class="messages">
<c:if test="${ isShowMessageForm }">
    <c:forEach items="${messages}" var="message">

            <div class="message">
                <div class="accountid-name">
                ＝＝＝＝＝＝＝＝＝＝＝
                <br />
                    アカウントID：<span class="accountid"><c:out value="${message.accountid}" /></span>
                    名前：<span class="name"><c:out value="${message.name}" /></span>
                </div>
                件名<div class="subject"><c:out value="${message.subject}" /></div>
                カテゴリー<div class="categry"><c:out value="${message.categry}" /></div>
                本文<div class="text"><c:out value="${message.text}" /></div>
                投稿日時<div class="date"><fmt:formatDate value="${message.created_date}" pattern="yyyy/MM/dd HH:mm:ss" /></div>
            <br />
コメント一覧<br />
<c:forEach items="${commentUser}" var="commentuser">

<c:if test="${message.id == commentuser.messageid }">
 <c:out value="コメント：${commentuser.comment}  名前：${commentuser.name} 投稿日時：${commentuser.createdDate}">
</c:out> <br />
</c:if>

</c:forEach>

 <form action="./" method="post">
           	<input name="messageid" value="${message.id}" id="id" type="hidden"/>
           	<br />
            <label for="comment">コメント投稿：</label>
			<input name="comment" id="comment" /> <br />
			 <input type="submit" value="登録" />
			 </form>
</div>
 </c:forEach>

      </c:if>
</div>
<br /><br />
            <div class="copyright"> Copyright(c)Kurumi Torii</div>
        </div>
    </body>
</html>