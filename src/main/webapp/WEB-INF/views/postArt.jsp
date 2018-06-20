<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>投稿画面</title>
<link href="css/personal.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<script src="js/jquery.js"></script>
<script src="js/jquery.magicpreview.js"></script>
<script src="js/jquery.magicpreview1.js"></script>

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
	<div class="col-sm-5">
		<form class="form-horizontal" action="postArtConfirm" name="artForm" method="post">
				<div class="form-group">
					<label for="title">タイトル</label>
					<input type="text" class="form-control" id="title" name="title">
				</div>
				<div class="form-group">
					<label for="content">内容</label><input type="button" class="btn btn-default" value="コードの挿入" onClick="addTF()"><br>
					<div>
					<textarea class="form-control" id="content" rows="8" name="content"></textarea>
					</div>
			</div>
			<button type="submit" class="btn btn-info">投稿確認</button>
		</form>
	</div>
	<div class="col-sm-5">
		<p class="title" id="mp_title">タイトル</p>
		<div class="content" id="mp_content">内容</div>
		<div id="mp_code"></div>
	</div>

</div>
</div>
<script>
	$('form.form-horizontal input:text').magicpreview('mp_');
	$('form.form-horizontal textarea').magicpreview1('mp_');

	function addTF()
{
	document.artForm.content.value += '<pre class="prettyprint linenums:1"><code>//ここにコードを記載してください</code></pre>';
}
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
</body>
</html>
