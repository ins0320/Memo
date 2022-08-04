<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
 	<c:import url="/WEB-INF/jsp/include/header.jsp"/>
 	
 	<section class= "d-flex d-flex justify-content-center">
 	<article>
 		<h1 class="text-center mt-5">로그인</h1>
 		<input type="text" class="form-control mt-3" id="idInput" placeholder="아이디">
 		<input type="password" class="form-control mt-3" id="passwordInput" placeholder="비밀번호">
 		<button class="btn btn-block btn-info mt-3" id="joinBtn">로그인</button>
 		<a href="/user/signup/view">회원가입</a>
 	</article>	
 	</section>
 	
 	<c:import url="WEB-INF/jsp/include/footer.jsp"/>
 
 </div>

</body>
</html>