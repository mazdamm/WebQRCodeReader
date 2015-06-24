<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QRCodeReader</title>
</head>
<body>
<form action="/qrcode_reader_web/Main" enctype="multipart/form-data" method="POST">
<h1>QRCodeReader</h1>
<input type="file" name="fileUploader" size="50">
<input type="submit" value="upload">
<br>
<br>
<div>読込結果：</div>
<%= request.getAttribute("result") %> 
</form>
</body>
</html>