<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認</title>
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
				<li class="menu">サトーさん</li>
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
	<div class="col-sm-10">
		この記事を削除しますか？
		<form class="form-horizontal" action="deleteArtResult" method="post">
			<div class="form-group">
				<label for="title">タイトル</label>
				<input type="text" class="form-control" id="title" readonly>
			</div>
			<div class="form-group">
				<label for="content">内容</label>
				<div>
				<textarea class="form-control" id="content" rows="10" readonly></textarea>
				</div>
			</div>
		<input type="submit" class="btn btn-info" name="button" value="記事一覧に戻る" onclick="location.href='deleteArt'; return false;">
		<button type="submit" class="btn btn-danger">削除</button>
		</form>
	</div>
</div>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
</body>
</html>
