<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投稿確認</title>
<link href="css/personal.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<header>
ヘッダー
</header>

<div class="container-fluid">
<div class="row">
	<div class="col-sm-2">
			<ul>
				<li class="menuTitle">User</li>
				<li class="menu">${ User.nickname }さん</li>
				<li class="menu"><a href="user">投稿記事一覧</a></li>
				<li class="menu"><a href="nickname">ニックネーム変更</a></li>
				<li class="blank"></li>
				<li class="menuTitle">Blog</li>
				<li class="menu"><a href="postArt">投稿</a></li>
				<li class="menu"><a href="editArt">編集</a></li>
				<li class="menu"><a href="deleteArt">削除</a></li>
				<li class="blank"></li>
				<li class="menuTitle">Other</li>
				<li class="menu"><a href="newAll">最新記事一覧</a></li>
				<li class="blank"></li>
				<li class="menu"><a href="logout">ログアウト</a></li>
			</ul>
	</div>
	<div class="col-sm-8">
		<form:form class="form-horizontal" action="postArtResult" modelAttribute="form">
		この内容でよろしいですか？
		<div class="article">
			<div class="title">
				<p class="title">${postArt.title}</p>
			</div>
			<div class="content">
				${postArt.content}
			</div>
		</div>
		<form:hidden path="title" value="${postArt.title}"></form:hidden>
		<form:hidden path="content" value="${postArt.content}"></form:hidden>
		<form:button class="btn btn-info" name="return">編集画面に戻る</form:button>
		<button type="submit" class="btn btn-success">投稿</button>
		</form:form>
	</div>

</div>
</div>
<script src="js/code.js">

</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
</body>
</html>