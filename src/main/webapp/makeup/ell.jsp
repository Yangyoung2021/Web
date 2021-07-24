<%--
  Created by IntelliJ IDEA.
  User: 999
  Date: 2021/7/14
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>EL动态获取虚拟目录</title>
</head>
<body>

<%--
3. 隐式对象：
			* el表达式中有11个隐式对象
			* pageContext：
				* 获取jsp其他八个内置对象
					* ${pageContext.request.contextPath}：动态获取虚拟目录
					--%>

<%--获取虚拟目录--%>
<h3>EL获取动态虚拟目录</h3>
${pageContext.request.contextPath}<br>


</body>
</html>
