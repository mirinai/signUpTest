<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 한 화면</title>
</head>
<body>
	<form action="logout.do">

		<table>
			<tr>
				<td>${loginUser.name}(${loginUser.userid} 로그인함</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="로그아웃">&nbsp;&nbsp; <input type="button"
					value="회원정보 바꾸기"
					onclick="location.href='memberUpdate.do?userid=${loginUser.userid}'">
				</td>
			</tr>
		</table>

	</form>


</body>
</html>