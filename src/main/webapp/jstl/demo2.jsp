<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>CHOOSE标签</title>
</head>
<body>
<%--

2. choose:相当于java代码的switch语句
			1. 使用choose标签声明         			相当于switch声明
            2. 使用when标签做判断         			相当于case
            3. 使用otherwise标签做其他情况的声明    	相当于default

3. foreach:相当于java代码的for语句
            两种作用：
                1.遍历容器
                    Java代码：
                        List<User> list;
                        for(User user : list){

                        }
                    jstl标签：

                2.重复操作
--%>
<%
        request.setAttribute("number",22);
%>
<c:choose >
    <c:when test="${number == 1}">星期一</c:when>
    <c:when test="${number == 2}">星期二</c:when>
    <c:when test="${number == 3}">星期三</c:when>
    <c:when test="${number == 4}">星期四</c:when>
    <c:when test="${number == 5}">星期五</c:when>
    <c:when test="${number == 6}">星期六</c:when>
    <c:when test="${number == 7}">星期日</c:when>

    <c:otherwise>日期格式错误 </c:otherwise>
</c:choose>
<br>
<%

    List<Object> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    request.setAttribute("lists",list);

%>

<h2>循环执行</h2>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
 ${i}              ${s.index}     ${s.count}<br>
</c:forEach>

<h1>遍历集合</h1>
<c:forEach items="${lists}" var="str" varStatus="s">

    ${s.index}   ${s.count}  ${str}<br>

</c:forEach>
</body>
</html>




