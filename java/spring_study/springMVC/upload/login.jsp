<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>SpringMVC Login</title>
</head>
<body>

<form action="upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="mfile" >  <!-- name的值 需要和controller中的参数 MultipartFile 的名称一致 -->
    <input type="submit" name="提交" >
</form>
</body>
</html>
