<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>***Answer View***</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/board_css/qna.css">
</head>
<body>
<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
<!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 --><!-- 답변 -->
	
	<section>
			<div class="qnaContainer">
			
				<ul id="qna">
					<li>Q&A</li>
				</ul>
				<div class="table-wrapper">
					<table class="table qna-view-table">
						<thead>
							<tr>
								<th>subject</th>
								<td>
									<img src="/img/board_img/realRe.png">A 제목제목
								</td>
							</tr>
							<tr>
								<th>Writer</th>
								<td><img src="/common_img/footerlogo2.png" height="27">
								<input type="hidden" name="noticeWriter" class="inputText"
								value="admin"></td>
							</tr>
							<tr>
								<th>Date</th>
								<td>19.10.17</td>
							</tr>
						</thead>
						<tbody>
							<tr>
							<td colspan="2">
								<div style="text-align:center;">
								<h1>내용</h1>
								<h1>내용</h1>
								<h1>내용</h1>
								<h1>내용</h1>
								<h1>내용</h1>
								<h1>내용</h1>
								<h1>내용</h1>
								</div>
								
								</td>
							</tr>
					</table>
				</div>
				<div class="qna-btn">
					<br>
				
					<a href="/WEB-INF/views/board/qna/qnaListTest.jsp" class="btn btn-default btn-md" >List</a>
					<!-- 관리자 일때만 보이게~ -->
					<!-- <a href="#" class="btn btn-default btn-md" >삭제</a> -->
					<a href="#" class="btn btn-default btn-md" >수정완료</a>
					
				</div>
			</div>
	</section>
	
</body>
</html>