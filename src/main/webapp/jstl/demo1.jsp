<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 999
  Date: 2021/7/14
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
<%--
## JSTL
	1. 概念：JavaServer Pages Tag Library  JSP标准标签库
		* 是由Apache组织提供的开源的免费的jsp标签		<标签>

	2. 作用：用于简化和替换jsp页面上的java代码

	3. 使用步骤：
		1. 导入jstl相关jar包
		2. 引入标签库：taglib指令：  <%@ taglib %>
		3. 使用标签

	4. 常用的JSTL标签
		1. if:相当于java代码的if语句
			1. 属性：
	            * test 必须属性，接受boolean表达式
	                * 如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
	                * 一般情况下，test属性值会结合el表达式一起使用
       		 2. 注意：
	       		 * c:if标签没有else情况，想要else情况，则可以在定义一个c:if标签

--%>
<%
    List<Object> list = new ArrayList<>();
    list.add("我是·····");
    request.setAttribute("list",list);
%>


<c:if test="${empty list}">
    list集合是空的
</c:if>

<c:if test="${not empty list}">
    list不集合是空的
</c:if>

</body>
</html>
