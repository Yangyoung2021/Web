<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 999
  Date: 2021/7/14
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <style>
        #red{
            color: red;
        }
    </style>
    <title>EL</title>
</head>
<body>
<%-- 2. 获取值
			1. el表达式只能从域对象中获取值
			2. 语法：
				1. ${域名称.键名}：从指定域中获取指定键的值
					* 域名称：
						1. pageScope		--> pageContext
						2. requestScope 	--> request
						3. sessionScope 	--> session
						4. applicationScope --> application（ServletContext）
					* 举例：在request域中存储了name=张三
					* 获取：${requestScope.name}

				2. ${键名}：表示依次从最小的域中查找是否有该键对应的值，直到找到为止。



				3. 获取对象、List集合、Map集合的值
					1. 对象：${域名称.键名.属性名}
						* 本质上会去调用对象的getter方法

					2. List集合：${域名称.键名[索引]} 索引越界默认显示空字符串，不会打乱页面布局

					3. Map集合：
						* ${域名称.键名.key名称}
						* ${域名称.键名["key名称"]} --%>


<%

    User user = new User();
    user.setName("阿猫");
    user.setAge(34);
    user.setBirthday(new Date());
    List<Object> list = new ArrayList<>();
    list.add("张三");
    list.add("李四");
    list.add(user);
    request.setAttribute("list",list);

    Map<Object,Object> map = new HashMap<>();
    map.put("m_name","lisa");
    map.put("m_age",23);
    map.put("user",user);
    request.setAttribute("map",map);

%>
        <h3>EL获取List集合的值</h3>
        <div id="red">${list}</div><br>
        ${list[0]}<br>
        ${list[2].name}


        <h3>EL获取Map集合的值</h3>
        ${map}<br>
        ${map.m_name}<br>
        ${map.m_age}<br>
        ${map.user.name}<br>

        ${map["m_name"]}<br>
        ${map["m_age"]}<br>

</body>
</html>
