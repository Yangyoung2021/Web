<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        window.onload = function (){
            let reset = document.getElementById("reset");
            reset.onclick = function (){
                let form = document.getElementById("form");
                form.action = "${pageContext.request.contextPath}/resetServlet";
                form.submit();
            }
        }

    </script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改用户信息</h3>
    <form action="${pageContext.request.contextPath}/updateServlet" method="post" id="form">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${find_user.name}"   placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男"  checked />男
            <input type="radio" name="gender" value="女"  />女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" value="${find_user.age}" name="age" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address" >
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" value="${find_user.qq}" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" value="${find_user.email}" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" id="reset" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" onclick="window.history.back()"/>
        </div>
    </form>
</div>
</body>
</html>
