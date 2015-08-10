<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>login</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="../jsencrypt/RSA.js"></script>
<script type="text/javascript" src="../jsencrypt/BigInt.js"></script>
<script type="text/javascript" src="../jsencrypt/Barrett.js"></script>
<script type="text/javascript">
	function rsalogin() {
		bodyRSA();
		var result = encryptedString(key, encodeURIComponent(document
				.getElementById("pwd").value));
		//alert(result);
		loginForm.action = "../ts_login.do?result=" + result;
		loginForm.submit();
	}
	var key;
	//初始化程序代码
	function bodyRSA() {
		setMaxDigits(130);
		key = new RSAKeyPair(
				"10001",
				"",
				"81212b94e1d1b2a202e0202fe022ffc5f70cce81084546b160b54d79e0acaafc29d472f7b9eaef5c4d5bdb0109d0f4cfa92064852355d5a5449ea1075bdbdc7155eb48a9fb12af54d1488c6081571c6cda1343260e523f315361ad5a72b4f0c3f67c859b1338af8fa2a2ad4a49a4aee58ecaa2645ff75186745a7c11a8095f6f");

	}
</script>
</head>

<body>
	<form id="loginForm" action="login.do" method="post">
		<table border="0">
			<tr>
				<td>Login:</td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" id="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="SUBMIT" onclick="rsalogin();" /></td>
			</tr>
		</table>
	</form>
</body>
</html>