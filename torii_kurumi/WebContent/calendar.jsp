<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>月毎集計</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body><center>

	<font face="HGS明朝B" size="8" color="#00008b" class=h4>カレンダー</font>
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
		<form action="calendar" method="post">

		 <br /> <br /> <input type="submit" value="編集" /> <br /> <a href="top">戻る</a>
		</form>
		<div class="copyright">Copyright(c)Kurumi Torii</div>
	</div>
	</center>
</body>
</html>