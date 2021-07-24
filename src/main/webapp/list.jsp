<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        // 提交选中的数据
        window.onload = function (){
            let delSel = document.getElementById("delete_b");
            let boxes = document.getElementsByClassName("boxes");
            delSel.onclick = function (){
                //判断是否有条目选中，如果没有就什么也不干
                let flag = false;

                for (let i = 0; i < boxes.length; i++) {
                    if(boxes[i].checked === true){//三个等号先直接判断类型是否一样，不一样直接false
                        flag = true;
                        break;
                    }
                }

                if(flag){
                    if(confirm("您确定要删除所选内容吗？")){
                        //删除选中
                        document.getElementById("form").submit();
                    }

                }

            }

            //获取第一个CheckBox
            let fir_box = document.getElementById("box");

            // let name_box = document.getElementsByClassName("box");

            fir_box.onclick = function () {
                //获取所有下面的CheckBox
                for (let i = 0; i < boxes.length; i++) {
                    boxes[i].checked = this.checked;
                }
            }
        }

    </script>


    <style>
        /*.table{*/
        /*    margin-bottom: 150px;*/
        /*    */
        /*}*/

        .tdd{
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${up.currentPage}&rows=5">
            <div class="form-group">
                <label for="ret_name">姓名</label>
                <input type="text" class="form-control" id="ret_name" name="name" value="${us.name}">
            </div>
            <div class="form-group">
                <label for="ret_address">籍贯</label>
                <input type="text" class="form-control" id="ret_address" name="address" value="${us.address}">
            </div>

            <div class="form-group">
                <label for="ret_email">邮箱</label>
                <input type="text" class="form-control" id="ret_email" name="email" value="${us.email}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>
    <form action="${pageContext.request.contextPath}/FindByPageServlet">
        <div style="float: right;margin: 5px;">
            <button type="submit" class="btn btn-default">返回首页</button>

            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a class="btn btn-primary" id="delete_b"
               href="javascript:void(0)">删除选中</a>

        </div>
    </form>

    <form action="${pageContext.request.contextPath}/delSelectedServlet" method="post" id="form">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="box" name="box"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${up.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" class="boxes" name="delSel" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/findModifyServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm"
                       href="${pageContext.request.contextPath}/delServlet?id=${user.id}">删除</a></td>
            </tr>

        </c:forEach>


    </table>
    </form>
    <form action="${pageContext.request.contextPath}/FindByPageServlet">
        <table class="table">
            <tr>
                <td>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">

                            <li>
                                <a href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${up.currentPage - 1}&rows=5&name=${us.name}&address=${us.address}&email=${us.email}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>

                            <c:forEach begin="1" end="${up.pageCount}" var="i">

                                <c:if test="${up.currentPage == i}">
                                    <li  class="active"><a href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${i}&rows=5&name=${us.name}&address=${us.address}&email=${us.email}">${i}</a></li>
                                </c:if>
                                <c:if test="${up.currentPage != i}">
                                    <li><a  href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${i}&rows=5&name=${us.name}&address=${us.address}&email=${us.email}">${i}</a></li>
                                </c:if>

                            </c:forEach>

                            <li>
                                <a href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${
                ((up.currentPage + 1) > up.pageCount) ? up.pageCount :(up.currentPage + 1)}&rows=5&name=${us.name}&address=${us.address}&email=${us.email}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                            <span style="font-size: 25px;margin-left: 5px;">
                共${up.totalCount}条记录，共${up.pageCount}页


            </span>

                        </ul>
                    </nav>
                </td>

            </tr>
        </table>

    </form>


</div>

</body>
</html>
