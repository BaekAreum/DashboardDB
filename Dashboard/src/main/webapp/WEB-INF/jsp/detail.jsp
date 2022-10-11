<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 상세 분석</title>
</head>
<body>
<h1>데이터 상세 분석</h1>
<a href="http://localhost:8080/Dashboard/detail/climate">기후 데이터</a>
<a href="http://localhost:8080/Dashboard/detail/gochang">고창 데이터</a>

<!-- 
<h1>게시판List</h1>

	<div class="detail">
		<form id="boardForm" name="boardForm" method="post">
			<table class="list_table">
				<colgroup>
					<col width="20%" />
					<col width="50%" />
					<col width="15%" />
					<col width="15%" />
				</colgroup>
				<tbody>
				<thead>

					<tr>
						<th>DAILY_DATA_DT</th>
						<th>DAILY_DATA_TIME</th>
						<th>HUMIDITY</th>
						<th>TEMPERATURE</th>
					</tr>
				</thead>

<!-- jstl 데이터베이스를 검색해 넘겨 받은 list 를 result 라는 이름으로 순차적으로 실행을 시키게 됨  java의 for문같이 순차적으로 실행시킴

				<c:forEach items="${json}" var="result">
					<tr>
						<td>${result.dailydatadt}</td>
						<td>${result.dailydatatime}</td>
						<td>${result.humidity}</td>
						<td>${result.temperature}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<br>
	-->
</body>
</html>