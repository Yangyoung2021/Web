package cn.itcast.jsp;


/**
 * JSP:
 *      1.指令
 *          *作用：用于配置JSP页面，导入资源文件
 *          *格式：
 *              <%@ 指令名称 属性名1=属性值 属性名2=属性值 ······%>
 *          *分类：
 *              1.page ：配置JSP页面的
 *                  * contentType：等同于response.setContentType()
 *                      1.设置响应体的mime类型以及字符集
 *                      2.设置当前jsp的编码（只能对高级开发工具生效，例如IDEA，否则就要用pageEncoding设置）
 *                  * import：导包
 *                  * errorPage：当页面发生异常后，为了不直接显示错误代码给用户，将直接跳转到该页面
 *                  * isErrorPage：标识当前页面是否为错误页面
 *                      * true：是，可以使用Exception内置对象
 *                      * false：不是，默认值，不能使用Exception内置对象
 *             2.include:页面包含的。倒入页面的资源文件
 *                  * <%@include file="top.jsp" %>
 *             3.taglib:导入资源
 *                  *<%@ taglib prefix="c" url="http://java.sun.com/jsp/jstl/core" %>
 *                      *prefix:前缀，可以自定义
 *      2.注释
 *          1.html注释：
 *              <!-- -->:只能注释html代码片段
 *          2.jsp注释
 *              <%-- --%>:可以注释所有
 *      3.内置对象
 *          * 在jsp页面中不需要创建，直接使用的对象
 * 		* 一共有9个：
 * 				变量名					真实类型						作用
        **** pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
        **** request					HttpServletRequest			一次请求访问的多个资源(转发)
        **** session					HttpSession					一次会话的多个请求间
        **** application				ServletContext				所有用户间共享数据
 * 			* response					HttpServletResponse			响应对象
 * 			* page						Object						当前页面(Servlet)的对象  this
 * 			* out						JspWriter					输出对象，数据输出到页面上
 * 			* config					ServletConfig				Servlet的配置对象
 * 			* exception					Throwable					异常对象
 */
public class Profile {
}
