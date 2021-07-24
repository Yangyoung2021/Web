<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 999
  Date: 2021/7/14
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());

    request.setAttribute("u",user);
%>

${u.name}<br>
${u.age}<br>
${u.birthday}<br>

${u.birStr}
</body>
</html>
