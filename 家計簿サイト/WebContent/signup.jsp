<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー新規登録</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body><center>

	<font face="HGS明朝B" size="8" color="#00008b" class=h4>ユーザー新規登録</font>
	<div class="main-contents">
		<c:if test="${ not empty errorMessages }">
			<div class="errorMessages">
				<ul>
					<c:forEach items="${errorMessages}" var="message">
						<li><c:out value="${message}" />
					</c:forEach>
				</ul>
			</div>
			<c:remove var="errorMessages" scope="session" />
		</c:if>
		<form action="signup" method="post">

			<br /> <label for="name">　　　　　　　　　　　名前：</label> <input name="name" id="name" />
			※10桁未満<br /> <label for="accountid">　　アカウントID：</label> <input
				name="accountid" id="accountid" /> <br /> <label for="password">　　　パスワード：</label>
			<input name="password" type="password" id="password" /> <br /> <label
				for="passwordConfirm">パスワード(確認用)：</label> <input
				name="passwordConfirm" type="password" id="passwordConfirm">
				<input name="account" value="1" id="account" type="hidden"/>

			<br />
			<br /> <label for="branch">支店：</label> <select name="branch">
				<option value="1">本社</option>
				<option value="2">支店A</option>
				<option value="3">支店B</option>
				<option value="4">支店C</option>
			</select><br /> <label for="department">役職・部署：</label> <select
				name="department">
				<option value="1">総務人事担当</option>
				<option value="2">情報管理担当</option>
				<option value="3">支店長</option>
				<option value="4">社員</option>



			</select> <br /> <br /> <input type="submit" value="登録" /> <br />
		</form>
		<form action="setting" method="post">
        <input name="loginUserDeartment" value="${loginUser.department}" id="deartment" type="hidden"/>
        <input type="submit" value="戻る" />
        </form>
		<div class="copyright">Copyright(c)Kurumi Torii</div>
	</div>
	</center>
</body>
</html>