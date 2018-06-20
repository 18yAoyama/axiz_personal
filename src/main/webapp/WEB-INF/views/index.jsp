<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
<link href="css/personal.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<header>
ヘッダー
</header>

<div class="loginForm">
<form class=”form-horizontal” action="login" method="post">
		<div class="form-group">
			<label for="id" class="col-sm-4">Id</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="id">
			</div>
		</div>
		<div class="form-group">
			<label for="pass" class="col-sm-4">Password</label>
			<div class="col-sm-8">
			<input type="password" class="form-control" id="pass">
			</div>
			<div class="BM">
	<button type="submit" class="btn">ログイン</button>
	</div>
	</div>
</form>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
</body>
</html>
