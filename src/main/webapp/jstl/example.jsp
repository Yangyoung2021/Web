<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Date" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <style>
        #table{
            text-align: center;
            width: 500px;
            margin: auto;
            vertical-align: middle;
        }

        #double{
            background: darkgray;
        }

    </style>
    <title>遍历演示</title>
</head>
<body>
<%

    List<User> list = new ArrayList<>();
    Collections.addAll(list,new User("张三",22,new Date()),new User("李四",23,new Date())
    ,new User("王五",25,new Date()));

    request.setAttribute("list",list);

%>

<table id="table" border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>生日</td>
    </tr>
<%--    数据行--%>
    <c:forEach items="${list}" var="user" varStatus="s">

        <c:if test="${s.count % 2 == 0}">
            <tr id="double">
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

        <c:if test="${s.count % 2 == 1}">
            <tr>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.birStr}</td>
            </tr>
        </c:if>

    </c:forEach>

</table>

</body>
</html>
