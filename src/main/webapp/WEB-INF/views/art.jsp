<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>記事</title>
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
				<li class="menu"><span class="user_name">${ User.nickname }</span>さん</li>
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
		<div class="article">
			<div class="title">
				<p class="title">${ art.title }</p>
			</div>
			<div class="content">${ art.content }</div>
		</div>
		<div class="comment">
			<p>投稿されたコメント</p>
				<c:forEach var="list" items="${comment}">
				    <div class="commentList">
				      <p class="user">${list.nickname}さん</p>
				      <p class="comment">${list.comment}</p>
				 <c:choose>
					<c:when test = "${User.user_id == list.user_id}">
					<div class="btn-toolbar"><div class="btn-group">
						<form:form class="form-horizontal" action="editC" modelAttribute="form">
							<form:hidden path="art_id" />
							<input type="hidden" name="comment_id" value="${list.comment_id}" />
							<input type="hidden" name="comment" value="${list.comment}" />
							<button type="submit" class="btn btn-info">編集</button>
						</form:form>
						<form:form class="form-horizontal" action="deleteC" modelAttribute="form">
							<form:hidden path="art_id" />
							<input type="hidden" name="comment_id" value="${list.comment_id}" />
							<input type="hidden" name="comment" value="${list.comment}" />
							<button type="submit" class="btn btn-danger">削除</button>
						</form:form>
					</div></div>
					</c:when>
				</c:choose>
					</div>
				</c:forEach>
			<div class="commentPost">
			<form:form class="form-horizontal" action="postComment" modelAttribute="form">
				<div class="postComment">
					<div class="form-group">
						<label for="content">コメント</label>
							<form:textarea class="form-control" path="comment" rows="3" />
							<form:hidden path="art_id" />
							<form:button type="submit" class="btn btn-success">投稿</form:button>
					</div>
				</div>
			</form:form>
			</div>
		</div>
	</div>
	<div class="col-sm-2"></div>
</div>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
<script src="https://cdn.rawgit.com/google/code-prettify/master/loader/run_prettify.js"></script>
</body>
</html>
